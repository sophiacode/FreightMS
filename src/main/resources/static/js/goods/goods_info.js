var goodsInfoData = {};

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
                    message: '物品名称不能为空'
                }
            }
        },
        point: {
            validators: {
                notEmpty: {
                    message: '所需积分不能为空'
                },
                regexp: {
                    regexp: /^0$|^[1-9]\d*$/,
                    message:'所需积分必须为整数'
                }
            }
        }
    }
};

var set = function(key, val) {
    if(typeof val == "undefined"){
        var o = $("#" + key)
        if(o != null && o.val() != ''){
            goodsInfoData[key] = o.val();
        }
    }else{
        goodsInfoData[key] = val;
    }

    return this;
};

var clearData = function () {
    goodsInfoData = {};
};

var collectData = function () {
    this.set('id').set('name').set('point').set("status");
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#goodsInfoForm").data("bootstrapValidator").validate();
    if(!$("#goodsInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url: URL_GOODS_ADD,
        async:true,
        data:goodsInfoData,
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

    $("#goodsInfoForm").data("bootstrapValidator").validate();
    if(!$("#goodsInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url: URL_GOODS_EDIT,
        async:false,
        data:goodsInfoData,
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

    $("#goodsInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
