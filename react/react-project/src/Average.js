import React, { useState, useMemo } from "react";

//전달된 배열의 값의 평균을 반환하는 함수
const getAverage = (numbers) => {
  console.log("평균값 계산중");
  //빈배열일 경우 0을 반환
  if (numbers.length === 0) return 0;

  //평균 = 총합을 계산해서 배열의 길이로 나눔
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};

const Average = () => {
  const [list, setList] = useState([]); //숫가값을 담고 있는 리스트
  const [number, setNumber] = useState(""); //입력창에 입력한 숫자

  const handleChange = (e) => {
    setNumber(e.target.value);
  };
  const handleClick = () => {
    //list(배열)에 number를 추가 =>업데이트된 새 배열을 반환하는 concat함수를 사용
    //문자열 number를 parseInt함수를 이용해서 숫자로 변경해서 배열에 추가
    const newList = list.concat(parseInt(number));
    setList(newList);
    setNumber("");
  };
  //[list]배열의 내용이 바뀔때만 getAverage함수를 실행해라
  const avg = useMemo(() => getAverage(list), [list]);
  return (
    <>
      <div>
        <input value={number} onChange={handleChange} />
        <button onClick={handleClick}>등록</button>
        <div>
          {list.map((v, i) => {
            return <span key={i}> {v}+</span>;
          })}
        </div>
        <div>평균값: {avg}</div>
      </div>
    </>
  );
};
export default Average;