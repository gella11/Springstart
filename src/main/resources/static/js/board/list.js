

boardlist()
function boardlist(){
    $.ajax({
            url: "/board/boardlist",
            type: "GET",
            success: function(list){

                 let html = '<tr> <th>번호</th> <th>제목</th> <th>작성자</th> </tr>';
                 list.forEach( (b) =>{
                    html += '<tr> <th>'+b.bno+'</th> <th onclick="viewboard('+b.bno+')">'+b.btitle+'</th> <th>'+b.mno+'</th> </tr>'
                    })
                document.querySelector('.listtable').innerHTML = html
            }
        })
}

function viewboard(bno){
    // 1.클릭한 게시물번호 저장
    sessionStorage.setItem("bno" , bno);
    // 2. 페이지 전환
    location.href="/board/view";
}