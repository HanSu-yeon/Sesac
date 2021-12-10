import React, { Component } from 'react';

class ScrollBox extends Component {
  scrollToBottom = () => {
    console.log(this.myBox);
    const { scrollHeight, clientHeight } = this.myBox;
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
