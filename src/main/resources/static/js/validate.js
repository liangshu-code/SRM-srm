/**
 * 表单验证：用户名和密码
 */

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			username : {
				required : true,
				remote: {
					url: "checkName",//后台处理程序
                    type:"post",//数据发送方式
                  	//传人的数据
                    data:{
                        username:function(){
                        	return $("#username").val();
                        }
                    } 
                } 
			},
			password : {
				required : true,
				remote: {
					url: "checkPwd",
					type: "post",
					data:{
						username:function(){
                        	return $("#username").val();
                        },
                        password:function(){
                        	return $("#password").val();
                        }
                    }
				}
			}
		},
		messages : {
			username : {
				required : icon + "请输入您的用户名",
				remote: icon + "该用户名不存在，请重新输入！"
			},
			password : {
				required : icon + "请输入您的密码",
				remote: icon + "密码错误！"
			}			
		}
	})
}