import React from 'react';
import cn from 'classnames';
import {
  MdCheckBox,
  MdCheckBoxOutlineBlank,
  MdRemoveCircleOutline,
} from 'react-icons/md';
import './TodoListItem.scss';
const TodoListItem = ({ todo, onRemove, onToggle }) => {
  const { id, text, checked } = todo;
  return (
    <div className="TodoListItem">
      {/* true면 checkbox에 checked 클래스 추가 */}
      <div
        className={cn('checkbox', { checked })}
        onClick={() => {
          onToggle(id);
        }}
      >
        {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
        <div className="text">{text}</div>
      </div>
      {/* 삭제 아이콘 클릭하면 onRemove(props)이벤트를 추가? */}
      <div className="remove" onClick={() => onRemove(id)}>
        <MdRemoveCircleOutline />
      </div>
    </div>
  );
};

export default TodoListItem;
