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
        telephone : $("#telephone").val(),
        name : $("#name").val(),
        status: $("#status").val(),
        authState: $("#authState").val(),
        onlineState: $("#onlineState").val(),
        workState : $("#workState").val(),
        createStartTime : $("#createStartTime").val(),
        createEndTime : $("#createEndTime").val()
    };

    table.bootstrapTable('refresh', {url:URL_DRIVER_LIST, query: queryParams});
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

    $.ajaxSetup({
        url:URL_DRIVER_STATUS,
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

    $.ajax();
};

$(function () {
    table = $('#driverTable');

    initTable();
    initDateTimePicker();

    $('#btn_search').click(search);
    $('#btn_reset').click(reset);
    $("#btn_freeze").click(changeStatus);
});
