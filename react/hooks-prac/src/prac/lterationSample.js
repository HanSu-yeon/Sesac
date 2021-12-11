import React, { useState } from 'react';
/*
세 가지 상태 사용 1. 데이터배열, 2. input,3.  id
*/
const IterationSample = () => {
  const [names, setNames] = useState([
    { id: 1, text: '눈사람' },
    { id: 2, text: '얼음' },
    { id: 3, text: '눈' },
    { id: 4, text: '바람' },
  ]);

  const [inputText, setInputText] = useState('');
  const [nextId, setNextId] = useState(5); //새로운 항목(객체)을 추가할 때 사용할 id

  const handleChange = e => {
    setInputText(e.target.value);
  };

  const handleAddItem = () => {
    const nextNames = names.concat({
      id: nextId,
      text: inputText,
    });
    setNames(nextNames);
    setNextId(nextId + 1);
    setInputText('');
  };

  const handleRemove = id => {
    const newNames = names.filter(name => name.id !== id);
    setNames(newNames);
  };
  const nameList = names.map(name => (
    <li key={name.id} onDoubleClick={() => handleRemove(name.id)}>
      {name.text}
    </li>
  ));

  return (
    <>
      <input type="text" value={inputText} onChange={handleChange} />
      <button onClick={handleAddItem}>추가</button>
      <ul>{nameList}</ul>
    </>
  );
};

export default IterationSample;
