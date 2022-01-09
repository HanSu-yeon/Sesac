import React, { useState, useRef, useCallback } from 'react';
import TodoTemplate from './components/TodoTemplate';
import TodoInsert from './components/TodoInsert';
import TodoList from './components/TodoList';

//children이 나타내는거?!?!?==TodoApp을 만들자( 태그 사이의 내용)
const App = () => {
  const [todos, setTodos] = useState([
    {
      id: 1,
      text: '할일이야 이거1',
      checked: false,
    },
    {
      id: 2,
      text: '할일이야 이거2',
      checked: false,
    },
    {
      id: 3,
      text: '할일이야 이거3',
      checked: true,
    },
  ]);

  const nextId = useRef(4);
  const onInsert = text => {
    const todo = {
      id: nextId.current,
      text,
      checked: false,
    };
    setTodos(todos.concat(todo));
    nextId.current += 1;
  };
  //onRemove 함수 선언하고 onRemove이벤트에 연결
  const onRemove = useCallback(
    id => {
      setTodos(todos.filter(todo => todo.id !== id));
    },
    [todos]
  );

  //수정기능
  const onToggle = useCallback(
    id => {
      setTodos(
        todos.map(todo =>
          todo.id === id ? { ...todo, checked: !todo.checked } : todo
        )
      );
    },
    [todos]
  );
  return (
    <TodoTemplate>
      <TodoInsert onInsert={onInsert} />
      <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
    </TodoTemplate>
  );
};
export default App;
