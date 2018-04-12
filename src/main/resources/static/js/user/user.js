var initTable = function() {
    $("#table_user").bootstrapTable({
        url: '/user_manage/list',         //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        queryParamsType:'limit',
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [2, 10, 25, 50, 100],        //可供选择的每页的行数（*）
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列

        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: 'id'
        }, {
            field: 'username',
            title: '用户名'
        }, {
            field: 'name',
            title: '姓名'
        }, {
            field: 'sex',
            title: '性别'
        }, {
            field: 'age',
            title: '年龄'
        }, {
            field: 'telephone',
            title: '手机号'
        }, {
            field: 'status',
            title: '状态'
        }, {
            field: 'role_id',
            title: '角色'
        }, {
            field: 'createTime',
            title: '创建时间'
        }]
    })
};

var initDateTimePicker = function() {
    $("input[name='dateTimePicker']").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
};

var search = function() {
    var queryParams = {
        username : $("#username").val(),
        name : $("#name").val(),
        sex : $("#sex").val(),
        age : $("#age").val(),
        telephone : $("#telephone").val(),
        status : $("#status").val(),
        type : $("#type").val(),
        createStartTime : $("#createStartTime").val(),
        createEndTime : $("#createEndTime").val()
    };

    $("#table_user").bootstrapTable('refresh', {url:'/user_manage/list', query: queryParams});
};

var reset = function() {
    $("#username").val("");
    $("#name").val("");
    $("#sex").val("");
    $("#age").val("");
    $("#telephone").val("");
    $("#status").val("");
    $("#type").val("");
    $("#createStartTime").val("");
    $("#createEndTime").val("");

    $("#table_user").bootstrapTable('refresh');
}

$(function () {
    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
});
