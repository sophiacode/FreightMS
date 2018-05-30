var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_ORDER_LIST,
        method: 'get',
        cache: false,
        pagination: true,
        sortable: false,
        queryParams : queryParams,
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
        },{
            field: 'consignorName',
            title: '货主姓名'
        },{
            field: 'driverName',
            title: '车主姓名'
        },{
            field: 'receiverName',
            title: '收货人姓名'
        },{
            field: 'receiverPhone',
            title: '收货人电话'
        },{
            field: 'startAddress',
            title: '发货地址'
        },{
            field: 'endAddress',
            title: '收货地址'
        },{
            field: 'price',
            title: '价格'
        },{
            field: 'distance',
            title: '距离'
        },{
            field: 'goodsType',
            title: '货物类型'
        },{
            field: 'remark',
            title: '备注信息'
        },{
            field: 'orderStatus',
            title: '订单状态'
        },{
            field: 'payStatus',
            title: '付款状态'
        },{
            field: 'createTime',
            title: '创建时间'
        }]
    });

    function queryParams(params){
        return {
            orderNo : $("#orderNo").val(),
            consignorName : $("#consignorName").val(),
            driverName : $("#driverName").val(),
            receiverName : $("#receiverName").val(),
            orderStatus: $("#orderStatus").val(),
            payStatus: $("#payStatus").val(),
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
    table.bootstrapTable('refresh', {url:URL_ORDER_LIST});
};

var reset = function() {
    $("#orderNo").val("");
    $("#consignorName").val("");
    $("#driverName").val("");
    $("#receiverName").val("");
    $("#orderStatus").val("");
    $("#payStatus").val("");
    $("#createStartTime").val("");
    $("#createEndTime").val("");

    table.bootstrapTable('refresh');
};

var refresh = function() {
    table.bootstrapTable('refresh');
};


$(function () {
    table = $('#orderTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
});
