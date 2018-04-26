var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_COMPLAINT_LIST,//TODO:修改URL
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
            field: 'orderNo',
            title: '订单号'
        }, {
            field: 'type',
            title: '投诉类型'
        }, {
            field: 'reason',
            title: '投诉原因'
        }, {
            field: 'status',
            title: '状态'
        }, {
            field: 'adminId',
            title: '处理者'
        }, {
            field: 'process',
            title: '处理说明'
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
        orderNo : $("#orderNo").val(),
        type : $("#type").val(),
        status : $("#status").val(),
        createStartTime : $("#createStartTime").val(),
        createEndTime : $("#createEndTime").val()
    };

    table.bootstrapTable('refresh', {url:URL_USER_LIST, query: queryParams}); //TODO:修改URL
};

var reset = function() {
    $("#orderNo").val("");
    $("#type").val("");
    $("#status").val("");
    $("#createStartTime").val("");
    $("#createEndTime").val("");

    table.bootstrapTable('refresh');
};

var refresh = function() {
    table.bootstrapTable('refresh');
};

var showHandle = function() {
    //TODO:处理投诉
};

$(function () {
    table = $('#complaintTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_handle').click(showHandle);

});
