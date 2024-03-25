import org.User;
import org.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.example.UserDao;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //1.获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql
        //方式一：getMapper()
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }
}

