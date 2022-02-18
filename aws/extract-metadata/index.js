'use strict';

var AWS = require('aws-sdk');
var exec = require('child_process').exec;

var fs = require('fs');

process.env['PATH'] = process.env['PATH'] + ':' + process.env['LAMBDA_TASK_ROOT'];

var s3 = new AWS.S3();
// ffprob를 통해서 추출한 메타데이터를 S3에 저장
function saveMetadataToS3(bodyy, bucket, key, callback) {
  console.log('saveMetadataToS3 is called...');
  //putObject:aws-sdk에서 제공해주는 함수
  S3.putObject(
    {
      Bucket: bucket, //버킷명
      Key: key, //파일명
      Body: body, //파일 내용
    },
    function (err, data) {
      if (err) {
        callback(err);
      }
    }
  );
}

//동영상의 메타데이터를 추출하는 함수
//어느 버킷에 있는 어떤 동영상의 메타데이터를 추출할거냐 그리고 그것을 버킷에서 가져와 그 동영상을 핸들링 해야함
//=> 그것이 어디(localFilename)에 저장할거냐
//호출한쪽으로 전달할 값 => callback함수 받아옴
function extractMetadata(sourceBucket, sourceKey, localFilename, callback) {
  console.log('extractMetadata is called...');
  //cmd: ffprobe를 실행해 주는 거
  //-v : 로그 레벨 지정, quiet: 로그 생략해라
  //-print_format json : 최종적인 메타데이터 형식을 json형식으로 저장해라
  //-show_format : 메타데이터를 추출해달라
  // /tmp/+localFilename +'"' : 동영상 위치 지정
  //메타데이터를 json형식으로 추출해라
  var cmd = 'bin/ffprobe -v quiet -print_format json -show_format "/tmp/' + localFilename + '"';
  //child_process라는 모듈의 exec기능을 이용해 실행
  //위에서 정의한 cmd 넘겨줌
  // 거기에대한 결과는 function해서 비동기 방식으로 받아볼 수 있다
  //function에는 error, stdout, stderr가 넘어온다
  exec(cmd, function (error, stdout, stderr) {
    //에러가 발생하지 x (=정확하게 처리가 되었다면)
    if (error === null) {
      //ex) test.mp4 -->test.json
      var metadataKey = sourceKey.split('.')[0] + '.json';
      //body는 stdout(출력되고있는 내용), 버킷이름: sourceBucket, 키 값:metadataKey
      saveMetadataToS3(stdout, sourceBucket, metadataKey, callback);
    } else {
      console.log(error);
      callback(error); //호출한쪽으로 callback해서 에러 넘겨준다
    }
  });
}

//S3 버킷에 있는 동영상 파일을 람다 실행환경 내부의 작업 디렉터리(/tmp)로 가져와서 저장하는 함수
//어느버킷(sourceBucket)으로부터 어떤파일(sourceKey)
function saveFileToFileSystem(sourceBucket, sourceKey, callback) {
  console.log('saveFileToFileSystem is called...');

  //확장자를 포함한
  var localFilename = sourceKey.split('/').pop();
  var file = fs.createWriteStream('/tmp/' + localFilename);

  s3.getObject({
    Bucket: sourceBucket,
    Key: sourceKey,
  })
    .createReadStream()
    .pipe(file);

  stream.on('error', function (error) {
    callback(error);
  });
  //파일을 다 읽어와 처리가 끝나면 function내용을 수행해라
  stream.on('close', function () {
    //메타데이터 추출 함수 추출
    extractMetadata(sourceBucket, sourceKey, localFilename, callback);
  });
}
//외부에서 람다함수가 트리거 되었을때 제일 먼저 실행되는 놈
exports.handler = function (event, context, callback) {
  //이 람다함수는 sns를 통해 트리거된다 => 인코디드버킷에 파일 추가되면 sns호출-> sns는 람다함수 트리거
  //-->람다함수는 sns를 통해 전달된다 -> sns가 전달해주는 이벤트에는 메세지부부ㄴ이 SNS를 호출한 놈에대한 정보가 들어있다(S3버킷에 대한 정보)
  var message = JSON.parse(event.Records[0].Sns.Message);
  //어떤 버킷이 sns를 호출했는지에 대한 정보
  var sourceBucket = message.Records[0].s3.bucket.name;
  //어떤 파일인지
  //+기호 나오면 공백문자로 바꿔라
  //그리고 이것이 url 인코딩 되어 있을수도 있으니 url디코딩해라
  var sourceKey = decodeURIComponent(message.Records[0].s3.object.key.replace(/\+/g, ' '));
  //s3버킷에서 내가 지정한 tmp폴더및에 파일로 지정하고 메타데이터ㅈ추출하는 함수 호출=>
  //ffprobe를 이용해 특정 디렉토리 tmp및에 있는 파일의 메타데이터 추출=> s3버킷에 저장하는 함수 호출
  //-->s3버킷에서 메타데이터 저장하고 빠져나온다
  saveFileToFileSystem(sourceBucket, sourceKey, callback);
};
