// -------------- 전역변수 -----------------//
let vcno = 0; // 카테고리 번호   // 카테고리 기본값 = 자유게시판

// 선택한 카테고리
//let category = document.querySelector('.categorylist').value

// 1. 카테고리 추가
function c_add(){
    let data= {
        vname : document.querySelector('.c_add').value
    }
    console.log(data)
    $.ajax({
        url:"/nonboard/cadd",
        type : "POST",
        data : JSON.stringify(data),
        contentType : "application/json",
        success : function(re){
            c_list()
        }
    })
}

// 2. 카테고리 리스트 출력
c_list()
function c_list(){
    $.ajax({
        url:"/nonboard/clist",
        type : "GET",
        success : function(re){
            html = '<button type="button" onclick="bcnochage(0)">전체보기</button>';
            re.forEach( c =>{
                html += '<button type="button" onclick="bcnochage('+c.vcno+')">'+c.vname+'</button>';
            })
            document.querySelector('.c_list').innerHTML = html;
        }
    })
}
// 카테고리 버튼을 클릭했을때 선택된 카테고리 번호 대입
function bcnochage( cno ){ vcno = cno; alert( vcno ); c_list();v_list();  }



// 방문록 추가
function v_add(){
    let data = {
            vcontent : document.querySelector('.vcontent').value,
            vname : document.querySelector('.vname').value,
            vcno : vcno
        }
    $.ajax({
            url:"/nonboard/vadd",
            type : "POST",
            data : JSON.stringify(data),
            contentType : "application/json",
            success : function(re){
                v_list();
            }
    })
}

// 방문록 리스트 출력
v_list()
function v_list(){
    $.ajax({
        url:"/nonboard/vlist",
        data : {"vcno": vcno},
        type : "GET",
        success : function(re){

            let html = '<tr>  <th> 번호 </th> <th> 내용 </th> <th> 작성자 </th></tr>';
            re.forEach( (v) => {
                html +=
                 '<tr>  <td> '+v.vno+' </td> <td >'+v.vcontent+' </td> <td> '+v.vname+' </td> '
                +'<td> <button type="button" onclick="upinput('+v.vno+')"> 수정 </button></td> '
                +'<td> <button type="button" onclick="vdelete('+v.vno+')"> 삭제 </button> </td> </tr>'
                +'<tr> <td></td> <td class="a'+v.vno+'"></td> <td></td> <tr>'
            })
            document.querySelector(".vlist").innerHTML = html;

        }
    })
}
// 수정 input 상자 생겨버리기
function upinput(vno){
    console.log(vno);
    html =      ' <td> 내용  수정 : <input type="text" class="vcontent2"> </td><br> '
              +' <td> 작성자 수정 : <input type="text" class="vname2"> </td><br> '
              +'<td> <button type="button" onclick="vupdate('+vno+')"> 수정등록 </button></td> '
     document.querySelector(`.a${vno}`).innerHTML = html
}

// 수정 input상자 값으로 수정해버리기
function vupdate(vno){
    console.log(vno);
    let data = {
        vcontent : document.querySelector('.vcontent2').value,
        vname : document.querySelector('.vname2').value,
        vno : vno
    }
    console.log(data);
    $.ajax({
        url : "/nonboard/vupdate",
        type : "put",
        data : JSON.stringify(data) ,
        contentType : "application/json",
        success : function(re) {
            if( re == true){
                alert('글 수정 성공');
                location.href="/nonboard/index";
            }
            else{ alert("글 수정 실패"); location.href="/nonboard/index"}
        }
    })
}

// 지워버리기
function vdelete(vno){
    $.ajax({
        url:"/nonboard/vdelete",
        data:{"vno" : vno},
        type:"delete",
        success : function(re){
           if(re == 1){
               alert('삭제되었슈')
               location.href="/nonboard/index";
           }else{
               alert('삭제 실패!')
               location.reload()
           }
        }
    })
}