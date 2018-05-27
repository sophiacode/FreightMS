var userInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        username: {
            validators: {
                notEmpty: {
                    message: "用户名不能为空"
                },
                stringLength: {
                    min: 5,
                    max: 30,
                    message: "用户名长度必须在5到30之间"
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9_]+$/,
                    message: '用户名只能由数字、字母和下划线组成'
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: "密码不能为空"
                },
                stringLength: {
                    min: 6,
                    max: 30,
                    message: "密码长度必须在6到30之间"
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9_]+$/,
                    message: '用户名只能由数字、字母和下划线组成'
                },
                identical: {
                    field: 'password2',
                    message: "两次密码输入不一致"
                }
            }
        },
        password2: {
            validators: {
                notEmpty:{
                    message: "确认密码不能为空"
                },
                identical: {
                    field: 'password',
                    message: "两次密码输入不一致"
                }
            }
        },
        new_password: {
            validators: {
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
        new_password2:{
            validators: {
                identical: {
                    field: 'new_password',
                    message: "两次密码输入不一致"
                }
            }
        },
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
    this.set('id').set('username').set('password').set('password2').set('new_password').set('new_password2')
        .set('name').set('sex').set('age').set('telephone').set('type')
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#userInfoForm").data("bootstrapValidator").validate();
    if(!$("#userInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_USER_ADD,
        async:true,
        data:userInfoData,
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
    $("#sex").val($("#sexValue").val());
    $("#type").val($("#typeValue").val());

    $("#userInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
