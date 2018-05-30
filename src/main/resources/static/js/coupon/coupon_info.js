var couponInfoData = {};

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
                    message: '优惠券名称不能为空'
                }
            }
        },
        activeTime: {
            validators: {
                notEmpty: {
                    message: '有效天数不能为空'
                },
                regexp: {
                    regexp: /^0$|^[1-9]\d*$/,
                    message:'有效天数必须为整数'
                }
            }
        },
        price: {
            validators: {
                notEmpty: {
                    message: '优惠价格不能为空'
                },
                regexp: {
                    regexp: /(^0$|^[1-9]\d*$)|(^0\.\d+$|^[1-9]\d*\.\d+$)/,
                    message:'优惠价格必须为数字'
                }
            }
        },
        startPrice:{
            validators: {
                regexp: {
                    regexp: /(^0$|^[1-9]\d*$)|(^0\.\d+$|^[1-9]\d*\.\d+$)/,
                    message:'起始价格必须为数字'
                }
            }
        }
    }
};

var set = function(key, val) {
    if(typeof val == "undefined"){
        var o = $("#" + key)
        if(o != null && o.val() != ''){
            couponInfoData[key] = o.val();
        }
    }else{
        couponInfoData[key] = val;
    }

    return this;
};

var clearData = function () {
    couponInfoData = {};
};

var collectData = function () {
    this.set('id').set('name').set('activeTime').set('price').set('startPrice');
};

var addSubmit = function () {
    clearData();
    collectData();

    $("#couponInfoForm").data("bootstrapValidator").validate();
    if(!$("#couponInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url: URL_COUPON_ADD,
        async:true,
        data:couponInfoData,
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

    $("#couponInfoForm").data("bootstrapValidator").validate();
    if(!$("#couponInfoForm").data("bootstrapValidator").isValid()){
        return;
    }

    $.ajaxSetup({
        url:URL_COUPON_EDIT,//TODO:URL
        async:false,
        data:couponInfoData,
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
    $("#couponInfoForm").bootstrapValidator(validator);

    $("#btn_add_submit").click(addSubmit);
    $("#btn_edit_submit").click(editSubmit);

    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    })
});
