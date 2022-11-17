


    $.ajax({
        url: "/board/boardlist",
        type: "GET",
        success: function(list){
            alert(list)
             let html = '<tr> <th>번호</th> <th>제목</th> <th>내용</th> </tr>';
             list.forEach( (b) =>{
                html += '<tr> <th>'+b.bno+'</th> <th>'+b.btitle+'</th> <th>'+b.bcontent+'</th> </tr>'
                })
            document.querySelector('.listtable').innerHTML = html
        }
    })
