import React from  'react';

export default function BoardWrite(props){

    const setbcategory = () => { alert('카테고리추가'); }
    const setboard     = () => { alert('게시글추가'); }

    return(
        <div>
            <h1> 글 쓰기 쓰기 </h1>
              <input type="text" className="bcname" />
                <button type="button" onClick={ setbcategory }> 카테고리추가 </button>
                <div name="bcategorybox"></div>

                <form className="boardform">
                    제목 : <input type="text" name="btitle"/> <br/>
                    내용 : <input type="text" name="bcontent"/> <br/>
                    첨파: <input type="file"  name="bfile"/> <br/>
                    <button type="button" onClick={ setboard }> 등록 </button>
                </form>
        </div>
    );
}