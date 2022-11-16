

    function setmember(){
        alert('setmember')
        let info = {
            meamil : document.querySelector('.meamil').value,
            mpassword : document.querySelector('.mpassword').value
        }

        let timerbox = document.querySelector('.timerbox').innerHTML
         if( timerbox != "인증성공" ){ alert("이메일 인증부터 해주세요~"); return;  }

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

// 2. 인증코드 요청
let auth = null;    // 발급된 인증코드
let timer = 0;      // 인증 시간
let timerinter = null; // setInterval 함수객체
function getauth(){

    let toemail = document.querySelector('.meamil').value


        $.ajax({
        url : "/member/getauth",
        data : {"toemail" : toemail},
        type : "get",
        success : function(re){
            auth = re; // 응답받은 코드 전역변수에 대입
            console.log(auth)
            alert(re)
            alert("해당 이메일로 인증코드 발송");
            document.querySelector('.getauthbtn').innerHTML = "재인증코드받기" // 버튼의 입력된 문자 변경
            timer = 120 // 초단위
            settimer()
        }
    })
}
// 4. 타이머함수

function settimer(){

    timerinter = setInterval(function(){
        let minutes, seconds;
        minutes = parseInt(timer / 60);
        seconds = parseInt(timer % 60);
        // 삼항연산자 : 조건 ? 참 : 거짓
        minutes = minutes < 10 ? "0"+minutes : minutes; // 두자리수 맞추기
        seconds = seconds < 10 ? "0"+seconds : seconds; // 두자리수 맞추기

        let timehtml = minutes+":"+seconds; // 분 : 초
        console.log(timehtml)
        document.querySelector('.timerbox').innerHtml = timehtml;

        timer--;

        if(timer < 0){
            clearInterval(timerinter); // 타이머 clear
            alert('인증실패')
            auth = null;
            document.querySelector('.getauthbtn').innerHtml = "인증코드받기"
        }
    },1000); // 1초 마다 함수 실행
}

// 3. 인증코드 확인
function authcode(){
    let authinput = document.querySelector('.authinput').value // 입력받은 인증코드
    if(authinput == auth){ // 입력받은 인증코드와 발급된 인증코드와 동일하면
        alert("인증코드 일치")
        clearInterval( timerinter ) // Interval 클리어
        auth = null; timer = 0;
        document.querySelector('.timerbox').innerHTML = "인증성공"
    }else{
        alert('인증코드 불일치')
    }
}