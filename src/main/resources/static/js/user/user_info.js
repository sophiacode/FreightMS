var userInfoData = {};

var set = function(key, val) {
    userInfoData[key] = (typeof val == "undefined")? $("#" + key).val():val;
    return this;
};

var clearData = function () {
    userInfoData = {};
};

var collectData = function () {
    this.set('username').set('password').set('password2').set('name').set('sex')
        .set('age').set('telephone').set('type')
};

var addSubmit = function () {
    console.log("addsubmit");

    clearData();
    collectData();

    $.ajaxSetup({
        url:URL_HEAD+"/user_manage/add",
        async:false,
        data:userInfoData,
        dataType:"json",
        success:function(data){

        }
    });

    $.ajax();
};

$(function (){
    $("#btn_add_submit").click(addSubmit);
});
