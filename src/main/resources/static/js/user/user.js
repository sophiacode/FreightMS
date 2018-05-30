var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_USER_LIST,                 //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        cache: false,                      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                  //是否显示分页（*）
        sortable: false,                   //是否启用排序
        queryParams : queryParams,
        queryParamsType:'limit',
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
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
            field: 'type',
            title: '类型'
        },
            {
            field: 'roleName',
            title: '角色'
        }, {
            field: 'createTime',
            title: '创建时间'
        }]
    });

    function queryParams(params) {
        return {
            username : $("#username").val(),
            name : $("#name").val(),
            sex : $("#sex").val(),
            age : $("#age").val(),
            telephone : $("#telephone").val(),
            status : $("#status").val(),
            type : $("#type").val(),
            createStartTime : $("#createStartTime").val(),
            createEndTime : $("#createEndTime").val(),
            limit: params.limit,
            offset: params.offset
        };
    }
};

var initDateTimePicker = function() {
    $("input[name='dateTimePicker']").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
};

var search = function() {
    table.bootstrapTable('refreshOptions',{pageNumber:1});
    table.bootstrapTable('refresh', {url:URL_USER_LIST});
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

    table.bootstrapTable('refresh');
};

var refresh = function() {
    table.bootstrapTable('refresh');
};

var showAdd = function() {
    layerIndex = layer.open({
        type: 2,
        title: '添加用户',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '520px'],
        content: URL_USER_ADD_VIEW
    });
};

var showEdit = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '修改用户资料',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content:URL_USER_EDIT_VIEW + "/" + selected[0].id
    })
};

var deleteUser = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length == 0){
        layer.msg("请先选择至少一条记录",{icon:2});
        return;
    }

    var idArray = new Array();
    var str = "确定要删除用户";
    var i;
    for(i in selected){
        idArray.push(selected[i].id);

        str += selected[i].username;
        if(i != selected.length - 1){
            str += "、";
        }
    }
    str += "吗？";

    $.ajaxSetup({
        url:URL_USER_DELETE,
        async:true,
        traditional:true,
        contentType: "application/json",
        data: {idArray : idArray},
        dataType:"json",
        success:function(data){
            layer.msg(data.msg, {icon : 1});
            refresh();
        },
        error:function(xhr){
            console.log(xhr);
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg'], { icon: 2} );
        }
    });

    layer.confirm(str, {
        btn: ['确认','取消'] //按钮
    }, function(){
        $.ajax();
    }, function(){

    });
};

var changeStatus = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length == 0){
        layer.msg("请先选择至少一条记录",{icon:2});
        return;
    }

    var idArray = new Array();
    var i;
    for(i in selected){
        idArray.push(selected[i].id);
    }
    console.log(idArray);

    $.ajax({
        url:URL_USER_STATUS,
        async:false,
        traditional:true,
        contentType: "application/json",
        data: {idArray : idArray},
        dataType:"json",
        success:function(data){
            layer.msg(data.msg, {icon : 1});
            refresh();
        },
        error:function(xhr){
            console.log(xhr);
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg'], { icon: 2} );
        }
    });
};

var showSetRole = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '分配角色',
        maxmin: true,
        shadeClose: true,
        area: ['400px', '300px'],
        content:URL_USER_ROLE_VIEW + "/" + selected[0].id
    })
};

$(function () {
    table = $('#userTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_add').click(showAdd);
    $('#btn_edit').click(showEdit);
    $('#btn_delete').click(deleteUser);
    $('#btn_freeze').click(changeStatus);
    $('#btn_role').click(showSetRole);
});
