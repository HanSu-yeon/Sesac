import React, { useRef, useCallback, useState } from 'react';
import produce from 'immer';
const App = () => {
  const nextId = useRef(1);
  //사용자 이름과 아이디를 가지고 있는 객체
  const [form, setForm] = useState({ name: '', username: '' });
  //리스트 항목
  const [data, setData] = useState({
    array: [],
    uselessValue: null,
  });
  //input수정하는 함수
  const handleChange = useCallback(
    e => {
      const { name, value } = e.target;

      setForm({
        ...form,
        [name]: value,
      });
      // setForm(
      //   produce(form,(draft)=>{
      //     draft[name]=value
      //   })
      // )
    },
    [form]
  );
  //form등록
  const handleSubmit = useCallback(
    e => {
      e.preventDefault();
      const info = {
        id: nextId.current,
        name: form.name,
        username: form.username,
      };
      setData({
        ...data,
        array: data.array.concat(info),
      });

      setForm({
        name: '',
        username: '',
      });
      nextId.current++;
    },
    [data, form.name, form.username]
  );

  const handleRemove = useCallback(
    id => {
      setData({
        ...data,
        array: data.array.filter(i => i.id !== id),
      });
    },
    [data]
  );
  return (
    <div>
      <form>
        <input name="username" value={form.username} onChange={handleChange} />
        <input name="name" />
        <button type="submit" onSubmit={handleSubmit}>
          등록
        </button>
      </form>
      <ul>
        {data.array.map(info => (
          <li key={info.id} onClick={() => handleRemove(info.id)}>
            {info.username} ({info.name})
          </li>
        ))}
      </ul>
    </div>
  );
};

export default App;
