import React , { useState , useEffect } from 'react'
import axios from 'axios'
export default function BoardWrite( props ) {

    let bcno = 0;
    const [ category , setCategory ] = useState('');    // 입력받은 카테고리명
    const [ categoryList , setCategoryList ] = useState([]);    // 서버로부터 가져온 카테고리 리스트

    // 1. 모든 카테고리 가져오기 함수 [ 실행조건 : 페이지가 [열렸을때] 렌더링 되었을때 ]
            const getbcategory = () => {
                                axios
                                    .get("/board/bcategorylist")
                                    .then( res => { setCategoryList( res.data ); console.log( res)  } )
                                    .catch( err => { console.log( err); } )
                                }
    // useEffect
            useEffect( getbcategory , [] ); // 페이지가 mount , unmount

    // 2. 입력된 카테고리 등록 함수 [ 실행조건 : 카테고리 등록 버튼 눌렀을때 ]
            const setbcategory = () => {
                                if( category == '' ){ alert("카테고리명을 입력후 등록해주세요"); return; }
                                axios
                                    .post( "/board/setbcategory" ,  { bcname : category } )
                                    .then( res => {
                                        if( res.data == true ) { alert("카테고리 등록성공"); console.log( res ) }
                                        else{ alert("카테고리 등록실패");  }
                                     })
                                    .catch( err => { console.log( err); } )
                                }

    // 게시글 등록
            const setboard = () => {
                            if(bcno == 0) { alert("카테고리 선택해주셩"); return;}
                            let boardform = document.querySelector('.boardform');

                            let formdata = new FormData(boardform);
                            console.log(formdata)
                            console.log(boardform)
                            formdata.set("bcno" , bcno ); // 폼데이터의 카테고리 번호 추가
                            axios
                                .post("/board/setboard" , formdata , { headers: { 'Content-Type': 'multipart/form-data'  } }  )
                                .then( res => {
                                               console.log(res.data);
                                               console.log(res);
                                               if(res.data == true) { alert('게시물 작성 성공')}
                                               else                 { alert('게시물 작성 실패')}
                                               } )
                                .catch( err => { console.log( err); } )
                        }

    return(
        <div>
            <h1> 글 쓰기 쓰기 </h1>
              <input type="text" value = {category} onChange={ (e)=> { setCategory(e.target.value ) }  } />
                <button type="button" onClick={ setbcategory }> 카테고리추가 </button>
                <div name="bcategorybox" ></div>
                <div className="bcategorybox">
                    {
                        categoryList.map( (c) => {
                            return( <button key={c.bcno } type="button" onClick={ ()=>{ bcno = c.bcno; alert("bcno:::"+bcno)} } > {c.bcname} </button>)
                        })
                    }
                </div>

                <form className="boardform">
                    제목 : <input type="text" name="btitle"/> <br/>
                    내용 : <input type="text" name="bcontent"/> <br/>
                    첨파: <input type="file"  name="bfile"/> <br/>
                    <button type="button" onClick={ setboard }> 등록 </button>
                </form>
        </div>
    );
}