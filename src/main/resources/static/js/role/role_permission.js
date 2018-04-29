var zTree;
var roleId = $("#roleId").val();
var setting = {
    view: {
        dblClickExpand: false,
        showLine: true,
        fontCss:{'color':'black','font-weight':'bold'},
        selectedMulti: true
    },
    check:{
        chkboxType: { "Y": "ps", "N": "ps" },
        chkStyle: "checkbox",
        enable: true
    },
    data: {
        simpleData: {//简单数据模式
            enable:true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: "1"
        }
    },
    callback: {
        beforeClick: function(treeId, treeNode) {
            zTree = $.fn.zTree.getZTreeObj("ztree");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);//如果是父节点，则展开该节点
            }else{
                zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
            }
        }
    }
};

var loadZTree = function() {
    var treeNodes = {};
    var checkedNodes = {};

    $.ajaxSetup({
        url: URL_ROLE_MANAGE + "/role_permission",
        async:false,
        traditional:true,
        contentType: "application/json",
        data: { roleId : roleId },
        dataType:"json",
        success:function(data){
            treeNodes = data.all;
            checkedNodes = data.checked;
        },
        error:function(xhr){
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg'], { icon: 2} );
        }
    });
    $.ajax();

    zTree = $.fn.zTree.init($("#ztree"), setting, treeNodes);

    for(var i in checkedNodes){
        var node = zTree.getNodeByParam("id", checkedNodes[i].id, null);
        zTree.checkNode(node, true, true, true);
    }
};

var submit = function() {
    var checkedNodes = zTree.getCheckedNodes(true);
    var idArray = new Array();
    for(var i in checkedNodes){
        idArray.push(checkedNodes[i].id);
    }

    $.ajaxSetup({
        url: URL_ROLE_MANAGE + "/change_permission",
        async:false,
        traditional:true,
        contentType: "application/json",
        data:{
            roleId : roleId ,
            idArray : idArray
        },
        dataType:"json",
        success:function(data){
            layer.msg(data.msg, {icon : 1});
            window.parent.refresh();
            parent.layer.close(window.parent.layerIndex);
        },
        error:function(xhr){
            var json = JSON.parse(xhr.responseText);
            layer.msg(json['msg'], { icon: 2} );
        }
    });
    $.ajax();
};


$(function() {
    loadZTree();

    $("#btn_submit").click(submit);
    $("#btn_cancel").click(function(){
        parent.layer.close(window.parent.layerIndex);
    });
});