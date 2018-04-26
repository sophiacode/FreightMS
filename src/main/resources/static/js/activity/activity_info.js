var activityInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        title: {
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
            activityInfoData[key] = o.val();
        }
    }else{
        activityInfoData[key] = val;
    }

    return this;
};

var clearData = function () {
    activityInfoData = {};
};

var collectData = function () {
    this.set('id').set('title').set('content').set('banner').set('status');
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#activityInfoForm").data("bootstrapValidator").validate();
    if(!$("#activityInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_ACTIVITY_ADD,
        async:true,
        data:activityInfoData,
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

    $("#activityInfoForm").data("bootstrapValidator").validate();
    if(!$("#activityInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_ACTIVITY_EDIT,
        async:false,
        data:activityInfoData,
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
    $("#status").val($("#statusValue").val());

    $("#activityInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
