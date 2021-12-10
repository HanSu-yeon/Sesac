import React, { Component } from 'react';
import './ValidationSample.css';

class ValidationSample extends Component {
  myinput = React.createRef();
  //입력한 패스워드를 저장할 상태변수
  state = {
    password: '',
    validated: false, //패스워드가 '0000'과 일치하는지 여부를 관리
    clicked: false, //검증 버튼 클릭 여부
  };
  //패스워드 입력창에 값이 변경되었을 때
  handleChange = e => {
    this.setState({ password: e.target.value });
  };
  //버튼을 클릭했을 때
  handleButtonClick = () => {
    //this.setState로 state값 업데이트
    // this.state.password === '0000'의 결과값이 true or false로 나온다
    this.setState({ clicked: true, validated: this.state.password === '0000' });
  };

  //리셋 버튼 클릭했을 때
  handleReset = () => {
    this.setState({ clicked: false, validated: false, password: '' });
    //input박스에 포커스
    //this.myinput.focus(); // ref 콜백함수ver
    this.myinput.current.focus(); //ref createRef버전
  };
  render() {
    return (
      <>
        <input
          ref={this.myinput} //ref createRef버전
          // ref={ref => (this.myinput = ref)}    //ref 콜백함수버전
          type="password"
          value={this.state.password}
          onChange={this.handleChange}
          className={this.state.clicked ? (this.state.validated ? 'valid' : 'invalid') : ''}
        />
        <button onClick={this.handleButtonClick}>패스워드 검증</button>
        <button onClick={this.handleReset}>리셋</button>
      </>
    );
  }
}

export default ValidationSample;
