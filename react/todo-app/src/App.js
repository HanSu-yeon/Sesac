import React, { useState } from "react";
import TodoTemplate from "./components/TodoTemplate";
import TodoInsert from "./components/TodoInsert";
import TodoList from "./components/TodoList";

const App = () => {
  const [todos, setTodos] = useState([
    {
      id: 1,
      text: "리액트 기초 알아보기",
    },
  ]);
  return (
    <TodoTemplate>
      <TodoInsert />
      <TodoList />
    </TodoTemplate>
  );
};

export default App;
