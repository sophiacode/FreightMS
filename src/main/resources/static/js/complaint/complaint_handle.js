submit = function () {
    if($("#process").val() == ''){
        layer.msg("请填写处理说明", {icon:2});
        return;
    }

    var data = {
        id:$("#complaintId").val(),
        process:$("#process").val()
    };

    $.ajax({
        url: URL_COMPLAINT_HANDLE,
        async:false,
        data:data,
        dataType:"json",
        success:function(data){
            layer.msg(data.msg, {icon : 1});
            window.parent.refresh();
            parent.layer.close(window.parent.layerIndex);
        },
        error:function(xhr){
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg'], { icon: 2} );
        }
    })
};

$(function(){
    $("#btn_submit").click(submit);
    $("#btn_cancel").click(function () {
        window.parent.refresh();
        parent.layer.close(window.parent.layerIndex);
    })
});