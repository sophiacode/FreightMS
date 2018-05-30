var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_COMPLAINT_LIST,
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
            field: 'adminName',
            title: '处理者'
        }, {
            field: 'process',
            title: '处理说明'
        }, {
            field: 'createTime',
            title: '创建时间'
        }]
    });

    function queryParams(params) {
        return  {
            orderNo : $("#orderNo").val(),
            type : $("#type").val(),
            status : $("#status").val(),
            createStartTime : $("#createStartTime").val(),
            createEndTime : $("#createEndTime").val(),
            limit: params.limit,
            offset: params.offset
        }
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
    table.bootstrapTable('refresh', {url:URL_COMPLAINT_LIST});
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
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '处理投诉',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['600px' , '400px'],
        content: URL_COMPLAINT_HANDLE_VIEW + "/" + selected[0].id
    });
};

$(function () {
    table = $('#complaintTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_handle').click(showHandle);
});
