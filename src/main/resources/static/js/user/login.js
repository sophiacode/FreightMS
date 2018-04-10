var loginSubmit = function() {
    console.log("loginSubmit");

    var data = {};

    data['username'] = $("#username").val();
    data['password'] = $('#password').val();

    var r = document.getElementsByName("rememberMe");
    data['isRemember'] = r[0].checked;

    $.ajaxSetup({
        url:URL_HEAD + "/login",
        async:false,
        data:data,
        dataType:"json",
        success:function(result){
            console.log("success");
            console.log(result.toString());
        },
        error:function(xhr,status,error){
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