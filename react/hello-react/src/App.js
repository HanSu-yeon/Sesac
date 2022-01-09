import MyComponentFunc from './MyComponentFunc';

import React from 'react';

const App = () => {
  return (
    <div>
      <MyComponentFunc name="react" favoriteNumber={1}>
        리액트 칠드런
      </MyComponentFunc>
    </div>
  );
};

export default App;
