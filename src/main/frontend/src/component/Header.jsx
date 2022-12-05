

import React from 'react';
import Styles from '../css/header.css';
import Logo from '../img/로고.jpg';
import { BrowserRouter, Routes , Route , Link , Router} from 'react-router-dom'
import axios from 'axios';  // react 비동기 통신 라이브러리


export default function Header(){

    // 1. 서버와 통신 [ axios ]
    // npm i axios
    axios.get('http://localhost:8080/member/getloginMno').then( res => { alert("서버와 통신됨!") } )
    // axios.type('URL').then(res => { alert('응답')})

    return(
        <div>
            <div className="header">
                <div className="header_logo">
                    <Link to="/"> <img className="logo" src={Logo} /> </Link>
                </div>
                <ul className="top_menu">
                    <li> <Link to="/" >  Home </Link> </li>
                    <li> <Link to="./member/Signup" > 회원가입 </Link> </li>
                    <li> <Link to="./member/Login" > 로그인 </Link> </li>
                    <li> <Link to="./Board/List" > 자유게시판 </Link> </li>
                    <li> <Link to="./Board/Write" > 글쓰기 </Link> </li>
                </ul>
            </div>
        </div>
    );
}