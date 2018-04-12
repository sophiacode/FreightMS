var loginSubmit = function() {
    console.log("loginSubmit");

    var data = {};

    data['username'] = $("#username").val();
    data['password'] = $('#password').val();

    var r = document.getElementsByName("rememberMe");
    data['isRemember'] = r[0].checked;

    $.ajaxSetup({
        url:URL_HEAD + "/login",
        async:true,
        data:data,
        dataType:"json",
        success:function(result){
            if(result.url);
        },
        error:function(xhr,status,error){
            console.log(xhr.responseText);
            var json = JSON.parse(xhr.responseText);
            console.log(json['msg']);
        }
    });

    $.ajax();
};


$(function() {
    console.log("login");

    $("#btn_submit").click(loginSubmit);
});