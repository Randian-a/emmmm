package asia.neg.emmmm;

import asia.neg.App;
import asia.neg.pojo.UserPojo;
import asia.neg.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author mxchen
 * @create 2019-11-22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class MyTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        List<UserPojo> userPojos = userService.selectAll();
        System.out.println(userPojos);
    }
}
