import { useReducer } from 'react';

function reducer(state, action) {
  return {
    //새로운 state만들고 바뀌는 부분만 바꿔줌
    ...state, //spread문법 = 기존 state를 새롭게 얕은 복사(참조)
    [action.name]: action.value, //바뀌는 부분
  };
}

const Info2 = () => {
  const [state, dispatch] = useReducer(reducer, { name: '', nickname: '' });
  const { name, nickname } = state;

  const handleChange = e => {
    dispatch(e.target);
  };

  return (
    <div>
      <div>
        <input name="name" value={name} onChange={handleChange} />
        <input name="nickname" value={nickname} onChange={handleChange} />
      </div>
      <div>이름: {name}</div>
      <div>닉네임: {nickname}</div>
    </div>
  );
};
export default Info2;
