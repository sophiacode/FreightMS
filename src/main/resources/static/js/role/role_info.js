var roleInfoData = {};

var validator = {
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        name: {
            validators: {
                notEmpty: {
                    message: "角色名不能为空"
                }
            }
        },
        identifier: {
            validators: {
                notEmpty:{
                    message:"标识符不能为空"
                },
                regexp: {
                    regexp: /^[a-zA-Z0-9_]+$/,
                    message: '标识符只能由数字、字母和下划线组成'
                }
            }
        },
        description: {
            validators: {

            }
        }
    }
};

var set = function(key, val) {
    if(typeof val == "undefined"){
        var o = $("#" + key)
        if(o != null && o.val() != ''){
            roleInfoData[key] = o.val();
        }
    }else{
        roleInfoData[key] = val;
    }

    return this;
};

var clearData = function () {
    roleInfoData = {};
};

var collectData = function () {
    this.set('id').set('name').set('identifier').set('description'); //TODO:set
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#roleInfoForm").data("bootstrapValidator").validate();
    if(!$("#roleInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url: URL_ROLE_ADD, //TODO:URL
        async:true,
        data:roleInfoData,
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

    $("#roleInfoForm").data("bootstrapValidator").validate();
    if(!$("#roleInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url: URL_ROLE_EDIT,//TODO:URL
        async:false,
        data:roleInfoData,
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
    $("#roleInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
