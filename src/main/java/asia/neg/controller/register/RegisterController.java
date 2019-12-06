package asia.neg.controller.register;

import asia.neg.pojo.UserExample;
import asia.neg.pojo.UserPojo;
import asia.neg.service.UserService;
import asia.neg.util.Msg;
import asia.neg.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

/**
 * 注册
 *
 * @author mxchen
 * @create 2019-12-06
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/ifUname")
    public Msg ifUname(String uname) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUnameEqualTo(uname);
        List<UserPojo> userPojos = userService.selectByExample(userExample);
        if (userPojos.size() == 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 注册方法
     */
    @RequestMapping("/userRegister")
    public ModelAndView register(UserPojo userPojo) {
        userPojo.setUid(genItemId());
        userPojo.setPassword(SecurityUtil.md5(userPojo.getPassword()));
        int insert = userService.insert(userPojo);
        ModelAndView mv = new ModelAndView();
        if (insert == 1) {
            mv.setViewName("login/login");
            mv.addObject("msg", "注册成功，请登录");
            return mv;
        } else {
            mv.setViewName("register/register");
            mv.addObject("msg", "注册失败");
            return mv;
        }
    }

    public static int genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        int id = new Long(str).intValue();
        return id;
    }
}
