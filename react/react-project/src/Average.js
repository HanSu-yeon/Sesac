import React, { useState, useMemo, useCallback, useRef } from "react";

//useMemo를 사용하면 함수형 컴포넌트 내부에서 발생하는 연산을 최적화할 수 있다
//1.리스트에 숫자를 추가하면 추가된 숫자들의 평균을 보여 주는 함수형 컴포넌트 작성

const Average = () => {
  //상태변경하려면 useState사용
  const [num, setNum] = useState(""); //입력창에 입력한 숫자
  const [numList, setNumList] = useState([]); //숫자값을 담고 있는 리스트
  const inputTag = useRef(null);
  //값이 바뀔 때마다 호출
  const handleChange = useCallback((e) => {
    setNum(e.target.value);
    console.log("처음 렌더링될때만");
  }, []); //컴포넌트가 처음 렌더링될 때만 함수 생성

  const handleClick = useCallback(
    (e) => {
      //numList배열에 num을 추가 =>업데이트된 새 배열을 반환하는 concat함수를 사용
      //문자열 number를 parseInt함수를 이용해서 숫자로 변경 후 배열에 추가

      const nextList = numList.concat(parseInt(num));
      setNumList(nextList);
      setNum("");
      inputTag.current.focus();
      console.log("함수생성");
    },
    [num, numList]
  ); //num 혹은 numList가 바뀌었을 때만 함수 생성

  //전달된 배열 값의 평균을 반환하는 함수
  const getAverage = (numbers) => {
    console.log("평균값 계산 중 .....");
    //빈 배열인 경우 0을 반환
    if (numbers.length === 0) return 0;
    // reduce함수 => 배열.reduce((누적값, 현잿값,인덱스,요소)=>{return 결과},초깃값)
    const sum = numbers.reduce((a, b) => a + b);
    return sum / numbers.length; //평균
  };

  //useMemo사용해 최적화하기
  //numList가 변경되면 getAverage()함수를 실행
  const avg = useMemo(() => getAverage(numList), [numList]);
  return (
    <div>
      <input value={num} onChange={handleChange} ref={inputTag} />
      <button onClick={handleClick}>계산</button>
      <ul>
        {numList.map((value, idx) => {
          return <li key={idx}>{value}</li>;
        })}
      </ul>
      <div>
        <b>평균:</b> {avg}
      </div>
    </div>
  );
};

export default Average;
