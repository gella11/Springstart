// 선택한 카테고리
//let category = document.querySelector('.categorylist').value

// 카테고리 추가
function c_add(){
    let data= {
        c_add : document.querySelector('.c_add').value
    }
    console.log(data)
    $.ajax({
        url:"/nonboard/cadd",
        type : "POST",
        data : JSON.stringify(data),
        contentType : "application/json",
        success : function(re){
            alert(re)
        }
    })
}

// 카테고리 리스트 출력
function c_list(){
    $.ajax({
        url:"",
        type : "GET",
        success : function(re){
            alert(re)
        }
    })
}

// 방문록 추가
function v_add(){
    let data= {
            v_add : document.querySelector('.v_add').value
        }
    $.ajax({
            url:"/nonboard/vadd",
            type : "POST",
            data : JSON.stringify(data),
            contentType : "application/json",
            success : function(re){
                alert(re)
            }
        })
}

// 방문록 리스트 출력
function v_list(){
    $.ajax({
        url:"",
        type : "GET",
        success : function(re){
            alert(re)
        }
    })
}