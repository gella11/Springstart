// -------------- 전역변수 -----------------//
let bcno = 2; // 카테고리 번호   // 카테고리 기본값 = 자유게시판

// 1. 게시물 등록 메소드 ♨첨부파일
function setboard(){

    let boardform = document.querySelector('.boardform')
    let formdata = new FormData(boardform);
    formdata.set("bcno" , bcno) // 폼 데이터에 데이터 추가 . 기존 폼 전체랑 set한 bcno 같이 담김

    $.ajax({
        url : "/board/setboard",
        type : "post",
        data : formdata,
        contentType : false,
        processData : false,
        success : function(re) {
            if( re == true){
                alert('글작성성공');
                location.href="/board/list";
            }
            else{ alert("글작성실패"); }
        }
    })
}
/*// 1. 게시물 등록 메소드
function setboard(){
    let data = {
        btitle : document.querySelector('.btitle').value ,
        bcontent : document.querySelector('.bcontent').value,
        bfile : document.querySelector('.bfile').value ,
        bcno : bcno
    }
    $.ajax({
        url : "/board/setboard",
        type : "post",
        data : JSON.stringify(data) ,
        contentType : "false",
        success : function(re) {
            if( re == true){
                alert('글작성성공');
                location.href="/board/list";
            }
            else{ alert("글작성실패"); }
        }
    })
}*/
// 2. 게시물 카테고리 등록 메소드
function setbcategory(){
    let data = { bcname : document.querySelector(".bcname").value }
    $.ajax({
        url : "/board/setbcategory" , type : "post",
        data : JSON.stringify(data), contentType : "application/json",
        success : function(re) {
            if( re == true){ alert('카테고리추가성공'); bcategorylist();}
            else{ alert('카테고리추가실패')}
        }
    })
}
// 3. 모든 카테고리 출력
bcategorylist()
function bcategorylist(){
    $.ajax({
        url : "/board/bcategorylist" ,  type : "get" ,
        success : function(re){
            let html = "";
            re.forEach( c =>{
                console.log( c )
                html += '<button type="button" onclick="bcnochage('+c.bcno+')">'+c.bcname+'</button>';
            })
            document.querySelector('.bcategorybox').innerHTML = html;
        }
    })
}
// 4. 카테고리 버튼을 클릭했을때 선택된 카테고리 번호 대입
function bcnochage( cno ){ bcno = cno; alert( bcno );  }

