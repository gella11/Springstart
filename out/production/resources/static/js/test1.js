 function GetMapping1() {
            $.ajax({
                url: '/api/v1/get-api/hello',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping2() {
            $.ajax({
                url: '/api/v1/get-api/name',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping3() {
            $.ajax({
                url: '/api/v1/get-api/variable1/variable1',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping4() {
            $.ajax({
                url: '/api/v1/get-api/variable2/variable2',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping5() {
            $.ajax({
                url: '/api/v1/get-api/variable3?variable=하하하',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping6() {
            $.ajax({
                url: '/api/v1/get-api/request1?name=qwe&email=qwe@qwe&organization=qweqweqwe',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping7() {
            $.ajax({
                url: '/api/v1/get-api/request2?key1=value1&key2=value2',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        function GetMapping8() {
            $.ajax({
                url: '/api/v1/get-api/request3?name=qwe&email=qwe@qwe&organization=qweqweqwe',
                type : 'GET',
                success: re =>{alert(re)}
            })
        }
        /////////////////////////////////////////////////////////////////
        /////////////////////// p o s t /////////////////////////////////
        /////////////////////////////////////////////////////////////////
        function postMapping1(){
            $.ajax({
                url: "/api/v1/post-api/domain",
                type : 'POST',
                success: re => { alert(re) }
            })
        }
        function postMapping2(){
        let member = {
            name : "유재석",
            email : "ㅂㅈㄷㅂㅈㄷ@ㅂㅈㄷㅂㅈㄷ",
            organization : "ㅂㅈㄷㅂㅈㄷㅂㅈㄷ"
        }
             $.ajax({
                url: '/api/v1/post-api/member',
                type : 'POST',
                data : JSON.stringify(member),
                contentType : 'application/json',   // 전송타입 : application/json
                success: re => { alert(re) }
            })
        }
        function postMapping3(){
        let member = {
            name : "유재석",
            email : "ㅂㅈㄷㅂㅈㄷ@ㅂㅈㄷㅂㅈㄷ",
            organization : "ㅂㅈㄷㅂㅈㄷㅂㅈㄷ"
        }
             $.ajax({
                url: '/api/v1/post-api/member2',
                type : 'POST',
                data : JSON.stringify(member),
                contentType : 'application/json',   // 전송타입 : application/json
                success: re => { alert(re) }
            })
        }
        ////////////////////////////////////////////////////
        ///////////////////// p u t ////////////////////////
        ////////////////////////////////////////////////////
        function putMapping1(){
        let member = { name : "유재석", email : "ㅂㅈㄷㅂㅈㄷ@ㅂㅈㄷㅂㅈㄷ", organization :"ㅂㅈㄷㅂㅈㄷㅂㅈㄷ" }
            $.ajax({
                url: "/api/v1/put-api/member",
                type : "PUT",
                data : JSON.stringify(member),
                contentType : 'application/json',
                success: re => { alert(re) }
            })
        }
        function putMapping2(){
        let member = { name : "유재석", email : "ㅂㅈㄷㅂㅈㄷ@ㅂㅈㄷㅂㅈㄷ", organization :"ㅂㅈㄷㅂㅈㄷㅂㅈㄷ" }
            $.ajax({
                url: "/api/v1/put-api/member1",
                type : "PUT",
                data : JSON.stringify(member),
                contentType : 'application/json',
                success: re => { console.log(re) }
            })
        }
        function putMapping3(){
        let member = { name : "유재석", email : "ㅂㅈㄷㅂㅈㄷ@ㅂㅈㄷㅂㅈㄷ", organization :"ㅂㅈㄷㅂㅈㄷㅂㅈㄷ" }
            $.ajax({
                url: "/api/v1/put-api/member2",
                type : "PUT",
                data : JSON.stringify(member),
                contentType : 'application/json',
                success: re => {
                    console.log(re)
                    console.log(re.name)
                   // let json = JSON.parse(re)  파싱할 필요 없음. 자동임
                   // console.log(json)
                }
            })
        }
        ////////////////////////////////////////////////////
        /////////////////// d e l e t //////////////////////
        ////////////////////////////////////////////////////
        function deleteMapping1(){
            $.ajax({
                url: "/api/v1/delete-api/호호호호",
                type : "DELETE",
                success: re => { alert(re) }
            })
        }
        function deleteMapping2(){
            $.ajax({
                url: "/api/v1/delete-api/request1?variable=호호호호",
                type : "DELETE",
                success: re => { alert(re) }
            })
        }