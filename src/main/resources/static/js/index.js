button()
function button(){
    $.ajax({
        url:"/member/getloginMno",
        type:"get",
        success: function(re){
        if(re !=0){
            html = '<button type="button" onclick="logout()"> 로그아웃 </button>'
                  +'<a href="/member/findpassword"><button type="button"> 비밀번호 찾기</button></a>'
                  +'<a href="/member/update"><button type="button"> 비밀번호 수정</button></a>'
                  +'<a href="/member/delete"><button type="button"> 회원탈퇴</button></a>'

             }
        else{
            html ='<a href="/member/signup"><button> 회원가입 </button></a>'
                  +'<a href="/member/login"> <button> 로그인 </button></a>'

            }
            document.querySelector('.buttonbox').innerHTML = html
        }
    })
}

function logout(){
    $.ajax({
        url:"/member/logout",
        type : "get",
        success: function(re){
                if(re==true){
                    alert('로그아웃 되었습니다.')
                    location.reload()
                    }
                else{
                    alert('로그아웃 실패')
                    }
            }
        })
    }

// 회원목록
list()
function list(){
    $.ajax({
        url:"/member/list",
        type : "get",
        success: function(list){
        console.log(list)
            let html = '<tr> <th>번호</th> <th>이메일</th> <th>비밀번호</th> </tr>';
            list.forEach( (m) =>{
                html += '<tr> <th>'+m.mno+'</th> <th>'+m.memail+'</th> <th>'+m.mpassword+'</th> </tr>'
            })
            document.querySelector('.mtable').innerHTML = html
        }
    })
}