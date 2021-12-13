import logo from "./logo.svg";
import "./App.css";
import { useRef, useState } from "react";
import produce from "immer";

function App() {
  //리스트 항목의 고유 식별자(ID)
  const nextId = useRef(1);
  //사용자 이름과 아이디를 가지고 있는 객체
  const [form, setForm] = useState({ name: "", username: "" });
  //리스트 항목
  const [data, setData] = useState({
    array: [],
    uselessValue: null,
  });

  const handleChange = (e) => {
    //e로부터 name, value뽑아온다
    const { name, value } = e.target;
    setForm(
      {
        //들어오는 데이터가(?)배열과 객체이기때문에 불변성을 위지하기위해 복사하고 업데이는하는거다  => 매번 이렇게 하는건 번거롭다
        //그래서 immer를 사용하는걸로 바꿔보자 (아직 안함)
        ...form,
        //계산된 속성명
        [name]: value,
      },
      [form]
    );
  };
  return (
    <div>
      <form action="">
        <input name="username" value={form.username} onChange={handleChange} />
        <input name="name" value={form.name} onChange={handleChange} />
        <button type="submit">등록</button>
      </form>
      <ul>
        {data.array.map((d) => (
          <li key={d.id}>
            {d.username} ({d.name})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
