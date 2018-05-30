var data = {};

var initDateTimePicker = function() {
    $("input[name='dateTimePicker']").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
};

var getRadioValue = function() {
    var radio = document.getElementsByName("condition");
    var i;
    for (i=0; i<radio.length; i++) {
        if (radio[i].checked) {
            return radio[i].value
        }
    }
    return -1;
};

var submit = function() {
    var condition = getRadioValue();
    var couponId = $("#couponId").val();

    if(condition == 1){
        data = {
            couponId: couponId,
            telephone: $("#telephone").val()
        };
        if(data['telephone'] == ''){
            layer.msg("请选择一种指定条件并填写必要信息", {icon:2});
            return;
        }
    }else if(condition == 2){
        data = {
            couponId: couponId,
            minPoint: $("#minPoint").val(),
            maxPoint: $("#maxPoint").val()
        };
        if(data['minPoint'] == '' && data['maxPoint'] == ''){
            layer.msg("请选择一种指定条件并填写必要信息", {icon:2});
            return;
        }
    }else if(condition == 3){
        data = {
            couponId: couponId,
            createStartTime : $("#createStartTime").val(),
            createEndTime : $("#createEndTime").val()
        };
        if(data['createStartTime'] == '' && data['createEndTime'] == ''){
            layer.msg("请选择一种指定条件并填写必要信息", {icon:2});
            return;
        }
    }else{
        layer.msg("请选择一种指定条件并填写必要信息", {icon:2});
        return;
    }

    $.ajax({
        url: URL_COUPON_RELEASE,
        async:true,
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
    });
};

$(function () {
    initDateTimePicker();

    $("#btn_submit").click(submit);
    $("#btn_cancel").click(function(){
        window.parent.refresh();
        parent.layer.close(window.parent.layerIndex);
    })
});

