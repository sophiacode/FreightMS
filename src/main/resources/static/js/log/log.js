var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_LOG_LIST,
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
            field: 'type',
            title: '日志类型'
        },{
            field: 'operation',
            title: '操作名称'
        },{
            field: 'username',
            title: '相关用户'
        },{
            field: 'status',
            title: '操作结果'
        }, {
            field: 'message',
            title: '消息'
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
        type : $('#type').val(),
        operation: $("#operation").val(),
        username: $("#username").val(),
        status: $("#status").val(),
        createStartTime : $("#createStartTime").val(),
        createEndTime : $("#createEndTime").val()
    };

    table.bootstrapTable('refresh', {url:URL_LOG_LIST, query: queryParams});
};

var reset = function() {
    $('#type').val("");
    $("#operation").val("");
    $("#username").val("");
    $("#status").val("");
    $("#createStartTime").val("");
    $("#createEndTime").val("");

    table.bootstrapTable('refresh');
};

var refresh = function() {
    table.bootstrapTable('refresh');
};

$(function () {
    table = $('#logTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
});
