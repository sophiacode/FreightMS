var initTable = function(table) {
    table.bootstrapTable({
        url: URL_MANAGE + "/chart/report",
        method: 'get',                      //请求方式（*）
        cache: false,                      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                  //是否显示分页（*）
        sortable: false,                   //是否启用排序
        queryParamsType:'limit',
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: false,                //是否启用点击选中行
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        columns: [{
            field: 'orderTotal',
            title: '总订单数'
        }, {
            field: 'orderProcess',
            title: '进行中订单数'
        }, {
            field: 'orderFinish',
            title: '已完成订单数'
        }, {
            field: 'orderCancel',
            title: '已取消订单数'
        }, {
            field: 'complaintCount',
            title: '投诉数'
        }, {
            field: 'priceTotal',
            title: '总成交金额'
        }, {
            field: 'pointDriver',
            title: '车主兑换积分'
        }, {
            field: 'pointConsignor',
            title: '货主兑换积分'
        }]
    });
};

var initDateTimePicker = function() {
    $("input[name='dateTimePicker']").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
};

var search = function() {
    var queryParams = {
        startTime: $("#startTime").val(),
        endTime: $("#endTime").val()
    };

    $("#reportTable").bootstrapTable('refresh', {url:URL_MANAGE + "/chart/report", query: queryParams});
};

$(function () {
    initTable($('#reportTable'));
    initDateTimePicker();

    $("#btn_search").click(search);
});