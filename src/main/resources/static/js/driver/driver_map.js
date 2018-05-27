$(function(){
    var map = new BMap.Map("map_container");
    var point = new BMap.Point(116.404, 39.915);  //天安门
    map.centerAndZoom(point, 15);
    window.setTimeout(function(){
        map.panTo(new BMap.Point(116.409, 39.918));
    }, 2000);
});