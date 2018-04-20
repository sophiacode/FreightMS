var notificationInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        title:{
            validators:{
                notEmpty:{
                    message: "标题不能为空"
                }
            }
        }
    }
};

var set = function(key, val) {
    if(typeof val == "undefined"){
        var o = $("#" + key)
        if(o != null && o.val() != ''){
            notificationInfoData[key] = o.val();
        }
    }else{
        notificationInfoData[key] = val;
    }

    return this;
};

var clearData = function () {
    notificationInfoData = {};
};

var collectData = function () {
    this.set('id').set('title').set('content');
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#notificationInfoForm").data("bootstrapValidator").validate();
    if(!$("#notificationInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_NOTIFICATION_ADD, //TODO:URL
        async:true,
        data:notificationInfoData,
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

    $.ajax();
};

var editSubmit = function() {
    clearData();
    collectData();

    $("#notificationInfoForm").data("bootstrapValidator").validate();
    if(!$("#notificationInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_NOTIFICATION_EDIT,//TODO:URL
        async:false,
        data:notificationInfoData,
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

$(function (){
    $("#notificationInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
