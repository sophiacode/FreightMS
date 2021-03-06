var layerIndex = -1;
var table;

var initTable = function() {
    table.bootstrapTable({
        url: URL_DRIVER_LIST,
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
            field: 'telephone',
            title: '手机号'
        }, {
            field: 'name',
            title: '姓名'
        }, {
            field: 'status',
            title: '状态'
        }, {
            field: 'authState',
            title: '认证状态'
        }, {
            field: 'onlineState',
            title: '在线状态'
        }, {
            field: 'workState',
            title: '接单状态'
        }, {
            field: 'point',
            title: '积分'
        }, {
            field: 'evaluateGrade',
            title: '评价等级'
        }, {
            field: 'idcard',
            title: '身份证号'
        }, {
            field: 'licenseNumber',
            title: '车牌号'
        }, {
            field: 'createTime',
            title: '创建时间'
        }]
    });

    function queryParams(params) {
        return {
            telephone : $("#telephone").val(),
            name : $("#name").val(),
            status: $("#status").val(),
            authState: $("#authState").val(),
            onlineState: $("#onlineState").val(),
            workState : $("#workState").val(),
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
    table.bootstrapTable('refresh', {url:URL_DRIVER_LIST});
};

var reset = function() {
    $("#telephone").val("");
    $("#name").val("");
    $("#status").val("");
    $("#authState").val("");
    $("#onlineState").val("");
    $("#workState").val("");
    $("#createStartTime").val("");
    $("#createEndTime").val("");

    table.bootstrapTable('refresh');
};

var refresh = function() {
    table.bootstrapTable('refresh');
};

var changeStatus = function() {
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

    $.ajax({
        url:URL_DRIVER_STATUS,
        async:false,
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
};

var showAuth = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length != 1){
        layer.msg("请先选择一条记录", {icon : 2});
        return;
    }

    layerIndex = layer.open({
        type: 2,
        title: '认证管理',
        maxmin: true,
        shadeClose: true,
        area: ['800px', '700px'],
        content: URL_DRIVER_AUTH_VIEW + "/" + selected[0].id
    })
};

var showMap = function() {
    var selected = table.bootstrapTable('getSelections');
    if(selected.length < 1){
        layer.msg("请先选择至少一条记录", {icon : 2});
        return;
    }

    var idArray = new Array();
    var i;
    for(i in selected){
        idArray.push(selected[i].id);
    }

    layerIndex = layer.open({
        type: 2,
        title: '位置查询',
        maxmin: true,
        shadeClose: true,
        area: ['1000px', '600px'],
        content: URL_DRIVER_MAP_VIEW + "/" + idArray
    })
};

$(function () {
    table = $('#driverTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $("#btn_freeze").click(changeStatus);
    $("#btn_auth").click(showAuth);
    $("#btn_map").click(showMap);
});
