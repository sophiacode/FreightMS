var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_ROLE_LIST,
        method: 'get',
        toolbar: '#toolbar',
        cache: false,
        pagination: true,
        sortable: false,
        queryParamsType:'limit',
        sidePagination: "server",
        pageNumber:1,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        showColumns: true,
        showRefresh: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        uniqueId: "id",
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: 'id'
        }, {
            field: 'name',
            title: '角色名'
        }, {
            field: 'identifier',
            title: '标识符'
        }, {
            field: 'description',
            title: '说明'
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
        name : $("#name").val(),
        identifier : $("#identifier").val(),
        createStartTime : $("#createStartTime").val(),
        createEndTime : $("#createEndTime").val()
    };

    table.bootstrapTable('refresh', {url:URL_ROLE_LIST, query: queryParams});
};

var reset = function() {
    $("#name").val("");
    $("#identifier").val("");
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
        title: '添加角色',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '520px'],
        content: URL_ROLE_ADD_VIEW
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
        title: '修改角色',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content: URL_ROLE_EDIT_VIEW + "/" + selected[0].id
    })
};

var showPermission = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '分配权限',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content: URL_ROLE_MANAGE + "/permission" + "/" + selected[0].id
    })
};

var deleteRole = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length == 0){
        layer.msg("请先选择至少一条记录",{icon:2});
        return;
    }

    var idArray = new Array();
    var str = "确定要删除角色";
    var i;
    for(i in selected){
        idArray.push(selected[i].id);

        str += selected[i].name; //TODO:修改字段
        if(i != selected.length - 1){
            str += "、";
        }
    }
    str += "吗？";

    $.ajaxSetup({
        url: URL_ROLE_DELETE,//TODO:URL
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

$(function () {
    table = $('#roleTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_add').click(showAdd);
    $('#btn_edit').click(showEdit);
    $('#btn_delete').click(deleteRole);
    $('#btn_permission').click(showPermission);
});
