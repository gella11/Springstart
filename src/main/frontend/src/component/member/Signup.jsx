import React from 'react'
import styles from './Signup.css'
import axios from 'axios'

function Signup(props) {
    // class -> className
    // onclick -> onClick
    // 태그 닫기
    // 함수호출 -> {} jsx 표현식

    // 1.setmember 이벤트 함수 정의 [화살표함수 정의]
    const setmember = () => {
        let info = {
                memail : document.querySelector('.memail').value ,
                mpassword : document.querySelector('.mpassword').value ,
                mphone : document.querySelector('.mphone').value
            }

        // 비동기 통신 [ ajax ]
        //           [ fetch(react내장) ]
        //           [ axios(react별도설치)  외부 라이브러리임 ]
        // ♨ axios 설치
        // npm : 라이브러리 빌드/관리 [ node.js ]
        // [ 현재 프로젝트내 ] npm install axios
        // import axios from 'axios'

        // axios 비동기통신 이용한 서버[spring] 통신
        // @CrossOrigin(origins = "http://localhost:3000")
        // axios.MethodType("통신URL 경로" , 전송할data) //  경로 빽엔드로 갈거임
        // axios.post() ,axios.get() ,axios.put() ,axios.delete()
        axios
            .post("http://localhost:8080/member/setmember" , info)  // 요청
            .then( res => { alert(res.data) } )                       //  응답
     }
    const getauth = () => { alert('원종이형 바보 getauth')  }
    const setimer = () => { alert('원종이형 바보 setimer')  }
    const authcode = () => { alert('원종이형 바보 authcode')  }


    return(
            <div>
                <h3> 회원가입 </h3>

                <div>
                    이메일 : <input type="text" className="memail"/>
                    <button type="button" onClick={setmember} className="getauthbtn">인증코드받기</button><br/>
                    <div className="authbox">
                        <input type="text" className="authinput"/>
                        <button type="button" className="authbtn" onClick={setmember}>인증</button>
                        <span className="timerbox"></span>
                    </div>
                </div>
                핸드폰 : <input type="text" className="mphone"/> <br/>
                비밀번호 : <input type="text" className="mpassword"/> <br/>
                <button type="button" onClick={setmember}>가입하기</button>
            </div>

    );
}

export default Signup;