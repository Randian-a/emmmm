package asia.neg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mxchen
 * @create 2019-11-21
 */
@Controller
public class LoginController {

    @RequestMapping("loginIn")
    public String loginIn(String username,String password){
        System.out.println(username+" "+password);
        return "index/index";
    }
}
