//$().ready(function() {
////     riqi();
//	validateRule();
//	 $("#signupForm").validate();
//});

//$.validator.setDefaults({
//	submitHandler : function() {
//		save();
//	}
//});
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
function save() {

	$.ajax({
		cache : true,
		type : "POST",
		url : "/supadd",
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
				required : true,
			},
			name_en : {
				required : true,
			},
			abbreviation : {
				required : true,
			},
			code : {
				required : true,
			},
			nature : {
				required : true,
			},
			property : {
			    required : true,

			},
		    mailing_address : {
			    required : true,
        	},
        	property : {
        	    required : true,

            },
        	mailing_address : {
        	    required : true,

            },
        	post_code : {
                required : true,
            },
        	company_website : {
                 required : true,
            },
        	business_registration : {
                  required : true,
            },
        	registered_capital : {
               required : true,
            },
            dateEstablishment : {
                 required : true,
                        },
            organization_code : {
                 required : true,
                         },
            staff_size : {
                   required : true,
                         },
            contact_id : {
                    required : true,
                        }

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
function riqi() {
    $('#dateEstablishment').datetimepicker({
        format: 'YYYY-MM-DD',
//        locale: moment.locale('zh-cn')
    });
    };