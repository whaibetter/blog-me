package cn.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 拦截器不拦截此基本跳转
 * @author whai_luo
 * @Date: 2020/7/4 9:33
 */
@Controller
public class JumpController {

    /**
     * 去注册
     * @return
     */
    @RequestMapping("toRegister")
    public String toRegister(){
        return "Main/Home/register";
    }

    /**
     * 去登陆
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "Main/Home/login";
    }


    /**
     * 404
     * @return
     */
    @RequestMapping("toError")
    public String toError(){
        return "Main/404";
    }


}
