var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_COUPON_LIST,
        method: 'get',
        toolbar: '#toolbar',
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
            field: 'name',
            title: '优惠券名称'
        }, {
            field: 'activeTime',
            title: '有效天数'
        }, {
            field: 'price',
            title: '优惠价格'
        }, {
            field: 'startPrice',
            title: '起始价格'
        }, {
            field: 'createTime',
            title: '创建时间'
        }]
    });

    function queryParams(params) {
        return {
            name : $("#name").val(),
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
    table.bootstrapTable('refresh', {url:URL_COUPON_LIST});
};

var reset = function() {
    $("#name").val("");
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
        title: '添加优惠券',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '520px'],
        content: URL_COUPON_ADD_VIEW
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
        title: '修改优惠券',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content: URL_COUPON_EDIT_VIEW + "/" + selected[0].id
    })
};

var showRelease = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '发放优惠券',
        maxmin: true,
        shadeClose: true,
        area: ['500px', '550px'],
        content: URL_COUPON_RELEASE_VIEW + "/" + selected[0].id
    })
};

var deleteCoupon = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length == 0){
        layer.msg("请先选择至少一条记录",{icon:2});
        return;
    }

    var idArray = new Array();
    var str = "确定要删除";
    var i;
    for(i in selected){
        idArray.push(selected[i].id);

        str += selected[i].name;
        if(i != selected.length - 1){
            str += "、";
        }
    }
    str += "吗？";

    $.ajaxSetup({
        url: URL_COUPON_DELETE,
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
    table = $('#couponTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_add').click(showAdd);
    $('#btn_edit').click(showEdit);
    $('#btn_delete').click(deleteCoupon);
    $("#btn_release").click(showRelease);
});
