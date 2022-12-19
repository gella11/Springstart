import React from  'react';



import { BrowserRouter, Routes , Route , Link , Router} from 'react-router-dom'



export default function Booklist(){
    return(
        <div>
               <ul>
                    <li> <Link to="/chapter3/Library"> 챕터3 </Link> </li>
                    <li> <Link to="/chapter4/Clock"> 챕터4 </Link> </li>
                    <li> <Link to="/chapter5/CommentList"> 챕터5 </Link> </li>
                    <li> <Link to="/chapter6/NotificationsList"> 챕터6 </Link> </li>
                    <li> <Link to="/chapter7/Accommodate"> 챕터7 </Link> </li>
                    <li> <Link to="/chapter8/Ex1_Event"> 챕터8 </Link> </li>
                    <li> <Link to="/chapter9/LandingPage"> 챕터9 </Link> </li>
                    <li> <Link to="/chapter11/Signup"> 챕터11 </Link> </li>
                    <li> <Link to="/chapter12/Calculator"> 챕터12 </Link> </li>
               </ul>

        </div>
    );
}