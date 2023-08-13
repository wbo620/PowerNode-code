import com.powernode.pojo.User;
import com.powernode.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class MyTest {

    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage("三","男",0);
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testDeleteUserById(){
        int num = userService.deleteUserById("15968162087363060");
        System.out.println(num);
    }
    @Test
    public void testGetRowCount(){
        int num = userService.getRowCount(null,"男");
        System.out.println(num);
    }

    @Test
    public void testCreateUser(){
        User u = new User("125412145214547846","身份证","121451245784","哈哈","男","23","工人");
        int num = userService.createUser(u);
        System.out.println("-----"+num);
    }

}

