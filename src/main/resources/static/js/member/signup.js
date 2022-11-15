

    function setmember(){
        alert('setmember')
        let info = {
            meamil : document.querySelector('.meamil').value,
            mpassword : document.querySelector('.mpassword').value
        }
        $.ajax({
            url: "/member/setmember",
            type : "POST",
            data : JSON.stringify(info),
            contentType: "application/json", // 형변환 필용 없음
            success: function(re){
                if(re != 0){
                    alert('회원가입 되었습니다.')
                    location.href="http://192.168.17.134:8080/member/index"
                }else{
                    alert('회원가입 실패')
                }
            }
        })
    }

