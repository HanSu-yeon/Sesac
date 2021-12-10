import React, { Component } from 'react';
import ScrollBox from './ScrollBox';

/*App컴포넌트에서 ScrollBox에 ref를 달고 버튼을 만들어 누르면,
ScrollBox 컴포넌트의 scrollToBottom메서드를 실행하도록 코드를 작성
*/
class App extends Component {
  render() {
    return (
      <div>
        <ScrollBox
          ref={ref => {
            this.scrollBox = ref;
          }}
        />
        <button
          onClick={() => {
            this.scrollBox.scrollToBottom();
          }}
        >
          맨 밑으로
        </button>
      </div>
    );
  }
}

export default App;
