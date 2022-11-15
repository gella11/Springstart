

    function setdelete(){
        var mpassword = document.getElementById('mpassword');
        $.ajax({
            url:"/member/setdelete",
            data:{"mpassword" : mpassword},
            type:"delete",
            success : function(re){
               if(re == 1){
                   alert('탈퇴되었습니다.')
                   location.href="http://192.168.17.134:8080/member/index"
               }else{
                   alert('탈퇴 실패')
                   location.reload()
               }
            }
        })
    }