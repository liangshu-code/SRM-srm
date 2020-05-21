$().ready(function() {
	validateRule();
	 $("#signupForm").validate();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
//function getCheckedRoles() {
//	var adIds = "";
//	$("input:checkbox[name=role]:checked").each(function(i) {
//		if (0 == i) {
//			adIds = $(this).val();
//		} else {
//			adIds += ("," + $(this).val());
//		}
//	});
//	return adIds;
//}
function update() {
    alert("23123")
	$.ajax({
		cache : true,
		type : "POST",
		url : "/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name_cn : {
				required : true
			},
			name_en : {
				required : true,
			},
			abbreviation : {
				required : true,
				minlength : 6
			},
			code : {
				required : true,
			},
			nature : {
				required : true,
			},
			property : {
				minlength : 2
			},
			    mailing_address : {
        	},
        	property : {

            },
        	mailing_address : {

            },
        	post_code : {

            },
        	company_website : {

            },
        	business_registration : {

            },
        	registered_capital : {

            },
            dateEstablishment : {

                        },
            organization_code : {

                         },
            staff_size : {

                         },
            contact_id : {
                        },
            staus : {
                      },
                      }

//		messages : {
//
//			name : {
//				required : icon + "请输入姓名"
//			},
//			username : {
//				required : icon + "请输入您的用户名",
//				minlength : icon + "用户名必须两个字符以上",
//				remote : icon + "用户名已经存在"
//			},
//			password : {
//				required : icon + "请输入您的密码",
//				minlength : icon + "密码必须6个字符以上"
//			},
//			confirm_password : {
//				required : icon + "请再次输入密码",
//				minlength : icon + "密码必须6个字符以上",
//				equalTo : icon + "两次输入的密码不一致"
//			},
//			email : icon + "请输入您的E-mail",
//		}
	})
}