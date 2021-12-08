import React, { useState } from 'react';
import Title from './Title';

function Todo() {
  const [count, setCount] = useState(0);
  const onClickUp = () => setCount(count + 1);
  return (
    <div>
      <Title count={count} />
      <button onClick={onClickUp}>증가</button>
    </div>
  );
}

export default Todo;
