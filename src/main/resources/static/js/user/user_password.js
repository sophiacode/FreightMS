var userInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        old_password: {
            validators:{
                notEmpty: {
                    message: "旧密码不能为空"
                }
            }
        },
        new_password: {
            validators: {
                notEmpty: {
                    message: "新密码不能为空"
                },
                stringLength: {
                    min: 6,
                    max: 30,
                    message: "密码长度必须在6到30之间"
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9_]+$/,
                    message: '密码只能由数字、字母和下划线组成'
                },
                identical: {
                    field: 'new_password2',
                    message: "两次密码输入不一致"
                }
            }
        },
        new_password2: {
            validators: {
                notEmpty:{
                    message: "确认密码不能为空"
                },
                identical: {
                    field: 'new_password',
                    message: "两次密码输入不一致"
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
    this.set('old_password').set('new_password').set('new_password2');
};

var submit = function() {
    clearData();
    collectData();

    $("#userInfoForm").data("bootstrapValidator").validate();
    if(!$("#userInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_USER_EDIT,
        async:false,
        data:userInfoData,
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
    $("#userInfoForm").bootstrapValidator(validator);

    $("#btn_submit").click(submit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
