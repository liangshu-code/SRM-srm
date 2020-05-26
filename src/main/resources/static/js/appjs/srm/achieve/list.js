var prefix = "/achieve"
$(document).ready(function() {
           	load();

});
function load() {

	var query = window.location.search.substring(1);
	var supplierId=query.split("=")[1]

    $('#exampleTable')
.bootstrapTable(

					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + '/count/'+supplierId, // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
//						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
//						pageSize : 10, // 如果设置了分页，每页数据条数
//						pageNumber : 1, // 如果设置了分布，首页页码
//						// search : true, // 是否显示搜索框
//						showColumns : false, // 是否显示内容下拉框（选择显示的列）
//						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
//						cache:false,							// "server"
//						queryParams : function(params) {
//							return {
//								// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
//								limit : params.limit,
//								offset : params.offset,
//								name : $('#searchName').val()
//							};
//						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
//
						columns : [
                        								{
                        									checkbox : true
                        								},
                        								{
                                                            field : 'achievementsName', // 列字段名
                                                            title : '供应商绩效名称' // 列标题
                                                        },{
                                                                  field : 'achievementsId', // 列字段名
                                                                   title : '供应商名称' // 列标题
                                                        },{

                                                            field : 'weight', // 列字段名
                                                            title : '权重' // 列标题
                                                        },
                        								{
                        									field : 'score', // 列字段名
                        									title : '得分' // 列标题
                        								},
                        								{
                        									field : 'totalcount',
                        									title : '综合得分'
                        								},
                        								{
                                                            title : '操作',
                                                            field : 'achieveType',
                                                         	align : 'center',
                                                            formatter : function(value, row, index) {


                                                         	var p = '<a class="btn btn-primary btn-sm '+s_add_h+'" href="#" mce_href="#" title="添加下级" onclick="add1(\''

                                                         	+row.achievementsId
                                                         	+ '\')"><i class="fa fa-plus"></i></a> ';

                                                           return p;
                                                         									}
                                                         								}]


					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
};
function add1(achievementsId) {
alert(achievementsId)
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add1/'+achievementsId
	});
}

function add2() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add2'
	});
}

function add3() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add3'
	});
}

function add4() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add4'
	});
}

function add5() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add5'
	});
}
