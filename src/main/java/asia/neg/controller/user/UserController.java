package asia.neg.controller.user;

import asia.neg.pojo.UserExample;
import asia.neg.pojo.UserPojo;
import asia.neg.service.UserService;
import asia.neg.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
   private UserService userService;


    @RequestMapping("/selectAll")
    public Msg selectAll(){
        List<UserPojo> userPojos = userService.selectAll();
        System.out.println(userPojos);
        return Msg.success().add("userPojos",userPojos);
    }
    //查全
    @RequestMapping(value="/countByExample",method= RequestMethod.GET)
    public Msg countByExample(@ModelAttribute UserPojo user){
                 UserExample example = new UserExample();
                 long l = userService.countByExample(example);
                return Msg.success().add("data",l);


    }
/*    @RequestMapping(value="/deleteByExample",method=RequestMethod.DELETE)
    public Msg deleteByExample(@ModelAttribute User user){

        UserExample example = new UserExample();


        Integer count = userService.deleteByExample(example);

        return Msg.success().add("data",count);
    }*/

    @RequestMapping(value="/deleteByPrimaryKey",method=RequestMethod.DELETE)
    public Msg deleteByPrimaryKey(Integer id){

          Integer count = userService.deleteByPrimaryKey(id);

            return Msg.success().add("data",count);
    }

   /* @RequestMapping(value="/insert",method=RequestMethod.POST)
    public Msg insert(@ModelAttribute User user){
        Integer count = userService.insert(user);
        return Msg.success().add("data",count);

    }*/

    @RequestMapping(value="/insertSelective",method=RequestMethod.POST)
    public Msg insertSelective(@ModelAttribute UserPojo user){
        Integer count = userService.insertSelective(user);
        return Msg.success().add("data",count);
    }

    @RequestMapping(value="/selectByExample",method=RequestMethod.GET)
    public Msg selectByExample(@ModelAttribute UserPojo user){
        UserExample example = new UserExample();
        List<UserPojo> list = userService.selectByExample(example);
        return Msg.success().add("data",list);
    }




    @RequestMapping(value="/selectByPrimaryKey",method=RequestMethod.GET)
    public Msg selectByPrimaryKey(Integer id){
        UserPojo user = userService.selectByPrimaryKey(id);
        return Msg.success().add("data",user);
    }

    @RequestMapping(value="/updateByPrimaryKey",method=RequestMethod.PUT)
    public Msg updateByPrimaryKey(@ModelAttribute  UserPojo record){
        Integer updateId = userService.updateByPrimaryKey(record);

        return  Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByExampleSelective",method=RequestMethod.PUT)
    public Msg updateByExampleSelective(@ModelAttribute UserPojo user){
        UserExample example = new UserExample();

        Integer updateId = userService.updateByExampleSelective(user,example);
        return  Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByPrimaryKeySelective",method=RequestMethod.PUT)
    public Msg updateByPrimaryKeySelective(@ModelAttribute UserPojo user){
        Integer updateId = userService.updateByPrimaryKeySelective(user);
        return Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByExample",method=RequestMethod.PUT)
    public Msg updateByExample(@ModelAttribute UserPojo user){
        UserExample example = new UserExample();

        Integer updateId = userService.updateByExample(user,example);
        return Msg.success().add("data",updateId);
    }


}
