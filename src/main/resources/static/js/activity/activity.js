var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_ACTIVITY_LIST,//TODO:修改URL
        method: 'get',
        toolbar: '#toolbar',
        cache: false,
        pagination: true,
        sortable: false,
        queryParams: queryParams,
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
            field: 'title',
            title: '标题'
        }, {
            field: 'content',
            title: '内容'
        },{
            field: 'adminName',
            title: '作者'
        },{
            field: 'status',
            title: '状态'
        },{
            field: 'createTime',
            title: '创建时间'
        }]
    });

    function queryParams(params) {
        return {
            title : $("#title").val(),
            authorName : $("#authorName").val(),
            status: $("#status").val(),
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
    table.bootstrapTable('refresh', {url:URL_ACTIVITY_LIST});
};

var reset = function() {
    $("#title").val("");
    $("#authorName").val("");
    $("#status").val("");
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
        title: '添加活动',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '520px'],
        content: URL_ACTIVITY_ADD_VIEW//TODO:URL
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
        title: '修改活动',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content: URL_ACTIVITY_EDIT_VIEW + "/" + selected[0].id
    })
};

var deleteActivity = function() {
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

    $.ajaxSetup({
        url: URL_ACTIVITY_DELETE,
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

    var str = "确定要删除这些活动吗？";
    layer.confirm(str, {
        btn: ['确认','取消'] //按钮
    }, function(){
        $.ajax();
    }, function(){

    });
};

$(function () {
    table = $('#activityTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_add').click(showAdd);
    $('#btn_edit').click(showEdit);
    $('#btn_delete').click(deleteActivity);
});
