var loginSubmit = function() {
    console.log("loginSubmit");

    var data = {};

    data['username'] = $("#username").val();
    data['password'] = $('#password').val();

    var r = document.getElementsByName("rememberMe");
    data['isRemember'] = r[0].checked;

    $.ajaxSetup({
        url:URL_LOGIN,
        async:true,
        data:data,
        dataType:"json",
        success:function(result){
            if(result.url!=null){
                window.location.href = result.url;
            }
        },
        error:function(xhr,status,error){
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg']);
        }
    });

    $.ajax();
};


$(function() {
    console.log("login");

    $("#btn_submit").click(loginSubmit);
});