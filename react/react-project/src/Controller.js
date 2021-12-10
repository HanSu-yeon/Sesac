import React, { Component } from 'react';

class Controller extends Component {
  state = {
    count: '',
  };

  clickPlusMinus = e => {
    this.setState({ count: e.target.innerText });
  };
  //콘솔에 패스워드 출력
  logging = msg => {
    console.log(msg);
  };
  render() {
    return (
      <>
        <h1>{this.state.count}</h1>
        <button onClick={this.clickPlusMinus}>+1</button>
        <button onClick={this.clickPlusMinus}>-1</button>
      </>
    );
  }
}

export default Controller;
