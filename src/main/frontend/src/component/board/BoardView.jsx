/*import {
    HashRouter,
    BrowserRouter,
    Routes,
    Route,
    Link,
    Router ,
    useParams // 라우터 경로상의 매개변수 호출 훅 [ 쿼리스트링 형식 ]
    }
from "react-router-dom";*/
import React , { useState , useEffect } from 'react';
import { useParams  } from "react-router-dom";
import axios from "axios";

export default function BoardView( props ){
    const params = useParams();
    const [ board , setBoard ] = useState( { } );
        useEffect(
             ()=>axios.get( "/board/getboard" , { params : { bno: params.bno } } ).then( res => { setBoard( res.data ) } )
                 , [] )
    return(
        <div>
            뷰 페이지로 들어옴 페이지번호 : { params.bno  }
            <div>{ board.btitle }</div>
            <div>{ board.bcontent }</div>
            <div>
                <button type="button"> 삭제 </button>
                <button type="button"> 수정 </button>
            </div>
        </div>
    )
}