
function setupdate(){
    let mpassword = document.querySelector('.mpassword').value

    $.ajax({
        url : "/member/setupdate",
        type : "PUT",
        data : {"mpassword" : mpassword},
        success : function(re){
            alert(re)
            location.reload()
            }
    })
}