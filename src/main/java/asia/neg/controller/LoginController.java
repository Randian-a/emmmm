package asia.neg.controller;

import asia.neg.pojo.UserExample;
import asia.neg.pojo.UserPojo;
import asia.neg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author mxchen
 * @create 2019-11-21
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginIn")
    public ModelAndView loginIn(String username, String password , HttpSession session) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUnameEqualTo(username);
        List<UserPojo> users = userService.selectByExample(userExample);
        ModelAndView view = new ModelAndView();
        if(users.size()<1){
            view.addObject("msg","用户不存在");
            view.setViewName("login/login");
            return view;
        }else{
            for ( UserPojo u : users){
                if(u.getPassword().equals(password)||u.getPassword()==password){
                    view.setViewName("index/index");
                    session.setAttribute("user",u);
                    System.out.println("session-set()"+u);
                    return view;
                }else {
                    view.addObject("msg","账号或密码错误");
                    view.setViewName("login/login");
                    return view;
                }
            }
            return null;
        }
    }
}
