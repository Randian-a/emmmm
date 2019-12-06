package asia.neg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mxchen
 * @create 2019-11-21
 */
@Controller
//@RequestMapping("/emmmm")
public class IndexController {
    /**
     * index
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index/index";
    }

    /**
     * test
     *
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "{msg:'test'}";
    }

    /**
     * login
     * @return
     */
    @RequestMapping("/toLogin")
    public String login() {

        return "login/login";
    }
    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/toRegisterPage")
    public String toRegister() {

        return "register/register";
    }
}
