





import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Home from './Home';
import Signup from './member/Signup';
import Login from './member/Login';
import List from './Board/List';
import Write from './Board/Write';

// 라우터 설치 [ 터미널 ] npm i react-router-dom
// import { 컴포넌트명 } from 'react-router-dom'
import { BrowserRouter, Routes , Route , Link , Router} from 'react-router-dom'
    // BrowserRouter :
    // Routes :
    // Route :
    // Link :

export default function Index(props){
    return(
        <div className="webbox">
            <BrowserRouter>
                <Header/>
                    <h3> 메인페이지 </h3>
                <Footer/>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/member/Signup" element={<Signup /> } />
                    <Route path="/member/Login" element={<Login /> } />
                    <Route path="/Board/List" element={<List /> } />
                    <Route path="/Board/Write" element={<Write /> } />
                </Routes>
            </BrowserRouter>
        </div>
    );
}