

    function findpassword(){
        let meamil = document.querySelector('.meamil').value

            $.ajax({
            url: "/member/getpassword",
            type : "get",
            data: {"meamil" : meamil},
            success : function(re){
                alert('회원님의 비밀번호 :'+re)
                location.href="http://192.168.17.134:8080/member/login"
            }
        })
    }