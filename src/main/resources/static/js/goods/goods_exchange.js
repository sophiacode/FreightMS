var initTable = function() {
    var queryParam = {
        goodsId : $("#goodsId").val()
    };

    $("#exchangeTable").bootstrapTable({
        url: URL_GOODS_MANAGE + "/goods_exchange",
        method: 'get',
        cache: false,
        pagination: true,
        sortable: false,
        query: queryParam,
        queryParamsType:'limit',
        sidePagination: "server",
        pageNumber:1,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        showColumns: false,
        showRefresh: false,
        minimumCountColumns: 2,
        clickToSelect: true,
        columns: [{
            field: 'user',
            title: '兑换人'
        }, {
            field: 'receiverName',
            title: '收货人姓名'
        }, {
            field: 'receiverTelephone',
            title: '收货人电话'
        }, {
            field: 'receiverAddress',
            title: '收货人地址'
        }]
    });

    $("#exchangeTable").bootstrapTable('refresh', {url:URL_GOODS_MANAGE + "/goods_exchange", query: queryParam});
};

$(function () {
    console.log($("#goodsId").val());
    initTable();
});