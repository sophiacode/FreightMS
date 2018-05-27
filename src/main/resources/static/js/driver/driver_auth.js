var authState;

var changeAuthState = function() {
    $.ajaxSetup({
        url:URL_DRIVER_MANAGE + "/driver_auth",
        async:false,
        data:{
            id: $("#driverId").val(),
            authState: authState
        },
        dataType:"json",
        success:function(data){
            layer.msg(data.msg, {icon : 1});
            window.parent.refresh();
            parent.layer.close(window.parent.layerIndex);
        },
        error:function(xhr){
            var json = JSON.parse(xhr.responseText)
            layer.msg(json['msg'], {icon : 2});
        }
    });

    $.ajax();

};

$(function() {
    $("#btn_pass").click(function(){
        authState = 3;
        changeAuthState();
    });

    $("#btn_reject").click(function(){
        authState = 4;
        changeAuthState();
    });

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});