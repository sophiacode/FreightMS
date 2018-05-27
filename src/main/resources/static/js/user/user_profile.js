var userInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        telephone: {
            validators: {
                regexp: {
                    regexp: /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$/,
                    message: "请输入正确的手机号"
                }
            }
        },
        age: {
            validators: {
                regexp: {
                    regexp: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/,
                    message: "请输入正确的年龄"
                }
            }
        }
    }
};

var set = function(key, val) {
    if(typeof val == "undefined"){
        var o = $("#" + key)
        if(o != null && o.val() != ''){
            userInfoData[key] = o.val();
        }
    }else{
        userInfoData[key] = val;
    }

    //userInfoData[key] = (typeof val == "undefined")? $("#" + key).val():val;
    return this;
};

var clearData = function () {
    userInfoData = {};
};

var collectData = function () {
    this.set('id').set('name').set('sex').set('age').set('telephone');
};

var editSubmit = function() {
    clearData();
    collectData();

    $("#profileForm").data("bootstrapValidator").validate();
    if(!$("#profileForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_USER_EDIT,
        async:false,
        data:userInfoData,
        dataType:"json",
        success:function(data){
            layer.msg(data.msg, {icon : 1});
        },
        error:function(xhr){
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg'], {icon : 2});
        }
    });

    $.ajax();
};

$(function (){
    $("#sex").val($("#sexValue").val());

    var typeValue = $("#typeValue").val();
    if(typeValue == 0){
        $("#type").val("普通用户")
    }else{
        $("#type").val("超级管理员")
    }

    $("#profileForm").bootstrapValidator(validator);
    $("#btn_edit_submit").click(editSubmit);
});