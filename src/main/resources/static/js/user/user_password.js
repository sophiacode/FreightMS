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

    return this;
};

var clearData = function () {
    userInfoData = {};
};

var collectData = function () {
    this.set('id').set('old_password').set('new_password').set('new_password2');
};

var submit = function() {
    clearData();
    collectData();

    $("#passwordForm").data("bootstrapValidator").validate();
    if(!$("#passwordForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_USER_PASSWORD,
        async:false,
        data:userInfoData,
        dataType:"json",
        success:function(data){
            layer.confirm(data.msg + ",请重新登录", {
                btn: ['确认'] //按钮
            }, function(){
                window.location.href = URL_PREFIX;
            });
        },
        error:function(xhr){
            var json = JSON.parse(xhr.responseText)
            layer.msg(json['msg'], {icon : 2});
        }
    });

    $.ajax();
};

$(function (){
    $("#passwordForm").bootstrapValidator(validator);

    $("#btn_submit").click(submit);

    $("#btn_reset").click(function(){
        $("#old_password").val("");
        $("#new_password").val("");
        $("#new_password2").val("");

    })
});
