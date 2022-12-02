

import React from 'react';
import Styles from '../css/header.css';
import Logo from '../img/강아지.jfif';
import { BrowserRouter, Routes , Route , Link , Router} from 'react-router-dom'
export default function Header(){
    return(
        <div>
            <img className="" src={Logo} />
            <h3 className="header_name"> 헤 드 </h3>
            <ul>
                <li> <Link to="/" >  Home </Link> </li>
                <li> <Link to="./member/Signup" > 회원가입 </Link> </li>
            </ul>
        </div>
    );
}