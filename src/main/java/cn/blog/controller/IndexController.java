package cn.blog.controller;

import cn.blog.entity.User;
import cn.blog.service.ArticleService;
import cn.blog.service.UserService;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页控制层
 * 包含
 *      注册
 *      登陆
 * @author whai_luo
 * @Date: 2020/7/3 13:58
 */
@Controller
@RequestMapping("/basic")
public class IndexController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;



    @RequestMapping(value = "/loginVerify",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        Map<String, Object> map = new HashMap<String, Object>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.loginVerify(new User(null,username,password,null));
        if(user==null) {
            map.put("code",0);
            map.put("msg","用户名或密码错误！");
        } else {
            //登录成功
            map.put("code",1);
            map.put("msg","登陆成功");
            //添加session
            request.getSession().setAttribute("user", user);

            //添加cookie
            //创建两个Cookie对象
            Cookie nameCookie = new Cookie("username", username);
            //设置Cookie的有效期为3天
            nameCookie.setMaxAge(60 * 60 * 24 * 3);
            Cookie pwdCookie = new Cookie("password", password);
            pwdCookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    /**
     *  退出登录
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/toLogin";
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value ="/registerUser")
    @ResponseBody
    public String register(HttpServletRequest request){

        Map<String, Object> map = new HashMap<String, Object>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userEmail = request.getParameter("useremail");

        User user = new User(username,password,userEmail);

        User usernameVerify = userService.usernameVerify(username);
        if (null!=usernameVerify){
            map.put("code",0);
            map.put("msg","用户名已经存在");
        }else {
            //注册成功
            map.put("code",1);
            map.put("msg","注册成功");
            userService.insertUser(user);
        }
        return new JSONObject(map).toString();
    }

}
