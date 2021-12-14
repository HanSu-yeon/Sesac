// import React from 'react';
import './TodoTemplate.scss';
//투두템플릿 큰 틀

const TodoTemplate = ({ children }) => {
  return (
    <div className="TodoTemplate">
      <div className="apptitle">TO&nbsp;&nbsp;&nbsp;DO</div>
      <div className="content">{children}</div>
    </div>
  );
};

export default TodoTemplate;
