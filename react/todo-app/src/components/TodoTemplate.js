//rsc단축명
import React from 'react';
import './TodoTemplate.scss';

// - 화면을 가운데 정렬시켜 주며, 앱 타이틀(일정 관리)을 보여 줌
// - children으로 내부 JSX를 props로 받아 와서 렌더링해 준다
const TodoTemplate = ({ children }) => {
  return (
    <div className="TodoTemplate">
      <div className="app-title">일정관리</div>
      <div className="content">{children}</div>
    </div>
  );
};

export default TodoTemplate;
