





import React from 'react';
import Header from './Header';
import Footer from './Footer';
import Signup from './member/Signup';
// 라우터 설치 [ 터미널 ] npm i react-router-dom
// import { 컴포넌트명 } from 'react-router-dom'
import { BrowserRouter, Routes , Route , Link , Router} from 'react-router-dom'
    // BrowserRouter :
    // Routes :
    // Route :
    // Link :

export default function Index(props){
    return(
        <div>
            <BrowserRouter>
                <Header/>
                    <h3> 메인페이지 </h3>
                <Footer/>
                <Routes>
                    <Route path="/" />
                    <Route path="/member/Signup" element={<Signup /> } />
                </Routes>
            </BrowserRouter>
        </div>
    );
}