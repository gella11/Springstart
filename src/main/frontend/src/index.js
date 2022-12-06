import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// 1. 사용할 컴포넌트 호출 [ import 컴포넌트명 from 파일명 ]
import Library from './Book/chapter3/Library';
import Clock from './Book/chapter4/Clock';
import CommentList from './Book/chapter5/CommentList';
import Signup from './component/member/Signup';

import Index from './component/Index';
import Header from './component/Header';
import Footer from './component/Footer';

import Chart from './Chart/Chart';
import Chart2 from './Chart/Chart2';
import Evaluation from './Chart/Evaluation';

import NotificationsList from './Book/chapter6/NotificationsList';
import Notification from './Book/chapter6/Notification';

import Counter from './Book/chapter7/Ex1_Hook';

// 2. Dom 컨테이너 [ public-> index.html 안에 있는 태그 ]
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
         <React.StrictMode>
           <Evaluation />
         </React.StrictMode>
       );

/*

root.render(
         <React.StrictMode>
           <App />
         </React.StrictMode>
       );
*/

/*

root.render(
         <React.StrictMode>
           <NotificationsList />
         </React.StrictMode>
       );
*/


/*

root.render(
         <React.StrictMode>
           <Index />
         </React.StrictMode>
       );
*/


/*
    3. Dom 컨테이너 렌더링
         1). 기본값 [ app.js 컴포넌트를 root 에 렌더링
            root.render(
              <React.StrictMode>
                <App />
              </React.StrictMode>
            );

         2).  [ Library 컴포넌트를 root 에 렌더링
            root.render(
              <React.StrictMode>
                <Library />
              </React.StrictMode>
            );

         3). [ Clock 컴포넌트를 root 에 렌더링 ]
            // 1. setInterval 1초마다 렌더링
                //setInterval( (인수) => { 실행문 } , 밀리초 )
             setInterval( () => {
                    root.render(
                      <React.StrictMode>
                        <Clock />
                      </React.StrictMode>
                    );
              } , 1000 );

 4.
        root.render(
          <React.StrictMode>
            <CommentList />
          </React.StrictMode>
        );


       root.render(
         <React.StrictMode>
           <Signup />
         </React.StrictMode>
       );
*/


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
