//모듈 가져오기
const mysql = require('mysql');
//mysql모듈 이용해 pool만들기
const pool = mysql.createPool({
  connectionLimit: 10,
  host: 'mysql',
  user: 'root',
  password: 'root',
  database: 'myapp',
});
//이 pool을 다르 파일에서도 쓸 수 있게 export
exports.pool = pool;
