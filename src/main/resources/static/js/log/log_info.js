var logInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        //TODO:具体验证器
    }
};

var set = function(key, val) {
    if(typeof val == "undefined"){
        var o = $("#" + key)
        if(o != null && o.val() != ''){
            logInfoData[key] = o.val();
        }
    }else{
        logInfoData[key] = val;
    }

    return this;
};

var clearData = function () {
    logInfoData = {};
};

var collectData = function () {
    this.set('id'). //TODO:set
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#logInfoForm").data("bootstrapValidator").validate();
    if(!$("#logInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:, //TODO:URL
        async:true,
        data:logInfoData,
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

    $("#logInfoForm").data("bootstrapValidator").validate();
    if(!$("#logInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:,//TODO:URL
        async:false,
        data:logInfoData,
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
    //TODO:初始化赋值
    $("#").val($("#").val());

    $("#logInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
