var initTable = function() {
    $("exchangeTable").bootstrapTable({
        url: URL_GOODS_MANAGE + "/goods_exchange",
        method: 'get',
        cache: false,
        pagination: true,
        sortable: false,
        query:{
            goodsId : $("#goodsId").val()
        },
        queryParamsType:'limit',
        sidePagination: "server",
        pageNumber:1,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        showColumns: true,
        showRefresh: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        columns: [{
            checkbox: true
        }, {
            field: 'user',
            title: '兑换人'
        }, {
            field: 'receiverName',
            title: '收货人姓名'
        }, {
            field: 'receiverPhone',
            title: '收货人电话'
        }, {
            field: 'receiverAddress',
            title: '收货人地址'
        }]
    })
};

$(function () {
    initTable();
});