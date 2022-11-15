

        function getlogin(){
            let info ={
                meamil : document.querySelector('.meamil').value,
                mpassword : document.querySelector('.mpassword').value
            }
            $.ajax({
                url: "/member/getmember",
                type : "POST",
                data : JSON.stringify(info),
                contentType: "application/json", // 형변환 필용 없음
                success: function(re){
                    alert(re)
                    if(re==1){
                    alert("로그인 되었습니다")
                    location.href="http://192.168.17.134:8080/member/index"
                    }else if(re==2){
                    alert("비밀번호 틀림")
                    location.href="http://192.168.17.134:8080/member/login"
                    }else{
                    alert("존재하지 않는 아이디입니다.")
                    location.href="http://192.168.17.134:8080/member/login"
                    }
                }
            })
        }
