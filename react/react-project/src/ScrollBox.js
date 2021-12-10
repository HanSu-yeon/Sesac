import React, { Component } from 'react';

//scrollTop: 세로 스크롤바 위치(0~350)
//scrollHeight: 스크롤이 있는 박스 안의 div높이(650)
//clientHeight: 스크롤이 있는 박스의 높이(300)
class ScrollBox extends Component {
  //이 메서드는 부모 컴포넌트인 App컴포넌트에서 ScrollBox에 ref를 달면 사용할 수 있다
  scrollToBottom = () => {
    console.log(this.myBox);
    /*아래 코드에는 비구조화 할당 문법 사용
    const  scrollHeight = this.myBox.scrollHeight
    const clientHeight = this.myBox.clientHeight
    */
    const { scrollHeight, clientHeight } = this.myBox;
    //스크롤바를 맨 아래쪽으로 내리기
    this.myBox.scrollTop = scrollHeight - clientHeight;
  };

  scrollToTop = () => {
    this.myBox.scrollTop = 0;
  };
  render() {
    const style = {
      border: '1px solid black',
      height: '300px',
      width: '300px',
      overflow: 'auto', //스크롤바가 생성될 수 있음
      position: 'relative',
    };

    const innerStyle = {
      width: '100%',
      height: '650px', //외부 DIV보다 높이가 높음 =스크롤바가 생성
      background: 'linear-gradient(white, black)',
    };

    return (
      <div style={style} ref={x => (this.myBox = x)}>
        <div style={innerStyle}></div>
      </div>
    );
  }
}

export default ScrollBox;
