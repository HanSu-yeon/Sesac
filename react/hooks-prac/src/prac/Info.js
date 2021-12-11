import { useEffect, useState } from 'react';
//여러개 상태관리하기
const Info = () => {
  const [name, setName] = useState('');
  const [nickname, setNickname] = useState('');

  const handleChangeName = e => {
    setName(e.target.value);
  };
  const onChangeNickname = e => {
    setNickname(e.target.value);
  };

  useEffect(() => {
    console.log('effect');
    console.log(name);
    return () => {
      console.log('cleanup');
      console.log(name);
    };
  }, [name]);

  return (
    <>
      <div>
        <input value={name} onChange={handleChangeName} type="text" />
        <input value={nickname} onChange={onChangeNickname} type="text" />
      </div>

      <div>
        <div>이름: {name}</div>
        <div>닉네임:{nickname}</div>
      </div>
    </>
  );
};

export default Info;
