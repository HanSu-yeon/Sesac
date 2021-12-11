import React, { useState } from 'react';
import './App.css';
import Info from './prac/Info';
const App = () => {
  const [visible, setVisible] = useState(false);

  return (
    <>
      <button
        onClick={() => {
          setVisible(!visible);
        }}
      >
        {visible ? '숨기기' : '보이기'}
      </button>
      <hr />
      {visible && <Info />}
    </>
  );
};
export default App;
