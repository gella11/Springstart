import React from  'react';

export default function Write(props){
    return(
        <div>
            <h1> 글 쓰기 쓰기 </h1>
              <input type="text" class="bcname" /> <button type="button" onclick="setbcategory()">카테고리추가</button>
              <div class="bcategorybox"></div>
                <form class="boardform">
                    제목 : <input type="text" name="btitle"/> <br/>
                    내용 : <input type="text" name="bcontent"/><br/>
                    첨파: <input type="file" name="bfile"/><br/>
                    <button type="button" onclick="setboard()"> 등록 </button>
                </form>
        </div>
    )
}