import React, { useState } from 'react';

const Counter = () => {
  const [count, setCount] = useState(0); //useState(초기값)
  return (
    <>
      <p>
        현재 카운터 값은
        <b>{count}</b> 입니다
      </p>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        +1
      </button>
      <button
        onClick={() => {
          setCount(count + 1);
        }}
      >
        -1
      </button>
    </>
  );
};

export default Counter;
