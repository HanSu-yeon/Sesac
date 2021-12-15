import { MdAdd } from 'react-icons/md';
import './TodoInsert.scss';
import { useCallback, useState } from 'react';

const TodoInsert = ({ onInsert }) => {
  const [inputValue, setInputValue] = useState('');

  const onChange = useCallback((e) => {
    setInputValue(e.target.value);
  }, []);

  const onSubmit = useCallback(
    (e) => {
      if (inputValue === '') {
        e.preventDefault();
        return;
      }
      onInsert(inputValue);
      setInputValue('');
      e.preventDefault();
    },
    [onInsert, inputValue],
  );
  return (
    <form className="TodoInsert" onSubmit={onSubmit}>
      <input
        type="text"
        placeholder="할 일 적으셈"
        value={inputValue}
        onChange={onChange}
      />
      <button type="submit">
        <MdAdd />
      </button>
    </form>
  );
};

export default TodoInsert;
