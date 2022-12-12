

        function getlogin(){
            let info ={
                memail : document.querySelector('.memail').value,
                mpassword : document.querySelector('.mpassword').value
            }
            $.ajax({
                url: "/member/getmember",
                type : "POST",
                data : JSON.stringify(info),
                contentType: "application/json", // 형변환 필용 없음
                success: function(re){
                    alert(re)

                }
            })
        }
