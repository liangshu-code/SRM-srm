var prefix = "/achieve"
$(document).ready(function() {
	load();
});
var load = function() {
	$('#exampleTable')
			.bootstrapTreeTable(
					{
						id : 'menuId',
						parentColumn : 'parentId',
						type : "GET", // 请求数据的ajax类型
						url : prefix + '/count', // 请求数据的ajax的url
						ajaxParams : {}, // 请求数据的ajax的data属性
						expandColumn : '1',// 在哪一列上面显示展开按钮
						striped : true, // 是否各行渐变色
						bordered : true, // 是否显示边框
						expandAll : false, // 是否全部展开
					//	toolbar : '#exampleToolbar',
						columns : [
								{
									title : '品质',
									field : 'quality',
									visible : false,
									align : 'center',
									valign : 'middle',
									width : '50px'
								},
								{
									title : '交货期',
									field : 'deliver'
								},

								{
									title : '价格及付款方式',
									field : 'paymentMethod',
									align : 'center',
									valign : 'middle',

								},
								{
									title : '投诉处理',
									field : 'complaint',
									align : 'center',
									valign : 'middle',

								},
								{
									title : '服务',
									field : 'service'
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',

								} ]
					});
}
function reLoad() {
	load();
}
function add(pId) {
	layer.open({
		type : 2,
		title : '增加菜单',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/' + pId // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(data) {
				if (data.code == 0) {
					layer.msg("删除成功");
					reLoad();
				} else {
					layer.msg(data.msg);
				}
			}
		});
	})
}
function edit(id) {
	layer.open({
		type : 2,
		title : '菜单修改',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function batchRemove() {
	// var rows = $('#exampleTable').bootstrapTable('getSelections');

}