package com.ilp3.system.controller;

import com.ilp3.common.controller.BaseController;
import com.ilp3.common.domain.Tree;
import com.ilp3.common.utils.R;
import com.ilp3.system.entity.MenuDO;
import com.ilp3.system.entity.SysUserDO;
import com.ilp3.system.service.MenuService;
import com.ilp3.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    UserService userService;
	
	@Autowired
    MenuService menuService;

	//@Log("请求访问主页")
	@GetMapping({"/index" })
	String Index(Model model) {
		// Tree<MenuDO> menuTree = menuService.getSysMenuTree(getUserId());
		logger.info("------------------menuservice:"+menuService);
		System.out.println(1111111111);
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		logger.info(getUser().getName());
		return "index";
	}

	@GetMapping({ "/", "", "/login"})
    String login(Model model) {
        return "login";
    }
	  
//	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
    R ajaxLogin(String username, String password, Model model) {
		//将用户名作为key的生成rule
		try {
			//password = AESUtils.encrypt(password, username);
			//password = MD5Utils.encrypt(username, password);
			logger.info("Password"+password);			
		} catch (Exception e1) {
			logger.error("加密失败------" + e1.getMessage());
		}
		System.out.println(username);
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (UnknownAccountException e) {
		    return R.error("用户名不存在");
		} catch (IncorrectCredentialsException e) {
		    return R.error("密码错误");
		}
	}
	//登录判断用户名是否存在
	@PostMapping("/checkName")
    @ResponseBody
    public String checkName(String username) {
        SysUserDO user = userService.findByName(username);
        //用户名不存在
        if(user == null) {
            return "false";
        }
        return "true";
    }
	//判断密码是否错误
	@PostMapping("/checkPwd")
	@ResponseBody
	public String checkPwd(String username, String password) {
	    SysUserDO user = userService.findByName(username);
	    try {
           //password  = AESUtils.encrypt(password, username);
           logger.info("Password"+password);			
        } catch (Exception e) {
            logger.error("加密失败------" + e.getMessage());
        }
	    //判断密码是否正确
	    if(!user.getPassword().equals(password)) {
	        return "false";
	    }
        return "true";
    }
	
//	@GetMapping("/logout")
//	String logout() {
//		ShiroUtils.logout();
//		return "redirect:/login";
//	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
	    Subject subject = SecurityUtils.getSubject();
	    subject.logout();
	    model.addAttribute("msg","安全退出！");
	    return "login";
	}

	@GetMapping("/home")
	String home(){
		return "/login";
	}
	@GetMapping("/main")
	String main() {
		return "main";
	}

	@GetMapping("/403")
	String error403() {
		return "403";
	}

}
