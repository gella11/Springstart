let bno = sessionStorage.getItem("bno");

if(bno == null){alert('옳바른 접근이 아닙니다.')}
viewload()
function viewload(){
    $.ajax({
        url: "/board/getboard",
        data: {"bno" : bno},
        success: function(list){
            alert(list)
             console.log(list)
             let html = '<tr> <th>번호</th> <th>제목</th> <th>작성자</th>  <th>내용</th>  </tr>';
             list.forEach( (b) =>{
                html += '<tr> <td>'+b.bno+'</td> <td>'+b.btitle+'</td>  <td>'+b.mno+'</td> <td>'+b.content+'</td> </tr>'
             })
            document.querySelector('.viewbox').innerHTML = html
        }
    })
}

function delboard(){
    $.ajax({
            url: "/board/delboard",
            type: "delete",
            data: {"bno" : bno},
            success: function(list){
                location.href="/board/list";
            }
    })
}