var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_GOODS_LIST,
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
            title: '物品名称'
        }, {
            field: 'point',
            title: '所需积分'
        }, {
            field: 'status',
            title: '状态'
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
        pointStart : $("#pointStart").val(),
        pointEnd : $("#pointEnd").val(),
        status : $("#status").val(),
        createStartTime : $("#createStartTime").val(),
        createEndTime : $("#createEndTime").val()
    };

    table.bootstrapTable('refresh', {url:URL_GOODS_LIST, query: queryParams}); //TODO:修改URL
};

var reset = function() {
    $("#name").val("");
    $("#pointStart").val("");
    $("#pointEnd").val("");
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
        title: '添加积分物品',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area : ['800px' , '520px'],
        content: URL_GOODS_ADD_VIEW
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
        title: '修改积分物品',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content: URL_GOODS_EDIT_VIEW + "/" + selected[0].id
    })
};

var deleteGoods = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length == 0){
        layer.msg("请先选择至少一条记录",{icon:2});
        return;
    }

    var idArray = new Array();
    var str = "确定要删除积分物品：";
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
        url: URL_GOODS_DELETE,
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

var showExchange = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '查看兑换记录',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '520px'],
        content: URL_GOODS_MANAGE + "/exchange/" + selected[0].id
    })
};

$(function () {
    table = $('#goodsTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $('#btn_add').click(showAdd);
    $('#btn_edit').click(showEdit);
    $('#btn_delete').click(deleteGoods);
    $('#btn_exchange').click(showExchange);
});
