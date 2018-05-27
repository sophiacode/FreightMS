var chartId = "chart";
var myChart = null;

generateYearRegisterChart = function(){
    var yearRegisterData = {
        labels : [],
        datasets : [
            {
                label: '车主用户',
                backgroundColor : "rgba(26,179,148,1)",
                data : []
            },
            {
                label: '货主用户',
                backgroundColor : "rgba(47,64,80,1)",
                data : []
            }
        ]
    };

    var options = {
        title: {
            display: true ,
            text: '年度用户注册柱状图',
            fontSize: 20
        }
    };

    //生成横轴标签
    $.ajax({
        type:"GET",
        url:URL_MANAGE + "/chart/yearLabels",
        dataType:"json",
        async:false,
        success:function(result){
            yearRegisterData.labels = result;
        }
    });

    //生成车主注册数据
    $.ajax({
        type:"GET",
        url:URL_MANAGE + "/chart/userYearData",
        data:{userType:"Driver"},
        dataType:"json",
        async:false,
        success:function(result){
            yearRegisterData.datasets[0].data = result;
        }
    });

    //生成货主注册数据
    $.ajax({
        type:"GET",
        url:URL_MANAGE + "/chart/userYearData",
        data:{userType:"Consignor"},
        dataType:"json",
        async:false,
        success:function(result){
            yearRegisterData.datasets[1].data = result;
        }
    });

    //生成柱状图
    var ctx = document.getElementById(chartId);
    if(myChart != null){
        myChart.destroy();
    }
    myChart = new Chart(ctx, {
        type: 'bar',
        data: yearRegisterData,
        options: options
    });
};

generateMonthRegisterChart = function() {
    var data = {
        labels : [],
        datasets : [
            {
                label: '车主用户',
                borderColor : "rgba(26,179,148,1)",
                //lineTension: 0,
                data : []
            },
            {
                label: '货主用户',
                borderColor : "rgba(47,64,80,1)",
                //lineTension: 0,
                data : []
            }
        ]
    };

    var options = {
        title: {
            display: true ,
            text: '最近一个月注册趋势图',
            fontSize: 20
        }
    };

    //生成横轴标签
    $.ajax({
        type:"GET",
        url:URL_MANAGE + "/chart/monthLabels",
        dataType:"json",
        async:false,
        success:function(result){
            data.labels = result;
        }
    });

    //生成车主注册数据
    $.ajax({
        type:"GET",
        url:URL_MANAGE + "/chart/userMonthData",
        data:{userType:"Driver"},
        dataType:"json",
        async:false,
        success:function(result){
            data.datasets[0].data = result;
        }
    });

    //生成货主注册数据
    $.ajax({
        type:"GET",
        url:URL_MANAGE + "/chart/userMonthData",
        data:{userType:"Consignor"},
        dataType:"json",
        async:false,
        success:function(result){
            data.datasets[1].data = result;
        }
    });

    //生成折线图
    var ctx = document.getElementById(chartId);
    if(myChart != null){
        myChart.destroy();
    }
    myChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: options
    });
};

$(function () {
    generateYearRegisterChart();

    $("#year_chart").click(generateYearRegisterChart);
    $("#month_chart").click(generateMonthRegisterChart);
});