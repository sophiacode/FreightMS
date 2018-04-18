var data = {};

var setRole = function() {
    data['user_id'] = $("#user_id").val();
    data['role_id'] = $("#roleSelect").val();

    $.ajaxSetup({
        url:URL_USER_ROLE,
        async:false,
        data:data,
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

$(function(){
    $("#btn_submit").click(setRole);
    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});