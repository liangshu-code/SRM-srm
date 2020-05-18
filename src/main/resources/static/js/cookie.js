/**
 * setCookie()设置cookie
 * getCookie()获取cookie
 */

function setCookie(){     
     var loginCode = $("#username").val(); //获取用户名信息    
     var pwd = $("#password").val(); //获取登陆密码信息    
     var checked = $("#remember_me").prop("checked");//获取“是否记住密码”复选框  

     if(checked){ //判断是否选中了“记住密码”复选框    
        $.cookie("login_code",loginCode);//调用jquery.cookie.js中的方法设置cookie中的用户名    
        //存储一个带7天期限的 cookie
        $.cookie("pwd",$.base64.encode(pwd),{ expires:7 });//调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密
     }else{     
        $.cookie("pwd", null);     
     }      
}

function getCookie(){
     var loginCode = $.cookie("login_code"); //获取cookie中的用户名    
     var pwd =  $.cookie("pwd"); //获取cookie中的登陆密码    
     if(pwd != null){//密码存在的话把“记住用户名和密码”复选框勾选住    
    	 $("#remember_me").prop("checked",true);
     }    
     if(loginCode != ''){//用户名存在的话把用户名填充到用户名文本框    
        $("#username").val(loginCode);    
     }    
     if(pwd != ''){//密码存在的话把密码填充到密码文本框    
        $("#password").val($.base64.decode(pwd));   
     }    
}
