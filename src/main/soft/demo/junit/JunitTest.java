package soft.demo.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import soft.demo.mapper.UserMapper;
import soft.demo.pojo.User;
import soft.demo.pojo.UserExample;

import java.util.List;

public class JunitTest {

    @Test
    /*
        增强：Mapper动态代理
        使用acx.getBean(UserMapper.class)
     */
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("soft/demo/config/applicationContext.xml");
        UserMapper mapper = acx.getBean(UserMapper.class);
        UserExample example = new UserExample();
        String username = "明";
        example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+username+"%");

        example.setOrderByClause("id desc");

        long i = mapper.countByExample(example);
        System.out.println(i);

        User user = mapper.selectByPrimaryKey(10);
        System.out.println(user.getUsername());

        List<User> users = mapper.selectByExample(example);
        for (User user2:users) {
            //System.out.println(user2.getUsername());
            System.out.println(user2.getId());
        }

    }

}
