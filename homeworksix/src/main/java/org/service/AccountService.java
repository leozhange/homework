package service;

import dao.AccountDao;
import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    public AccountService() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        accountDao = sqlSession.getMapper(AccountDao.class);
    }
    private void destroy(){
        try{
            sqlSession.commit();
            sqlSession.close();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    List<Account> findAll(){

    }
    void deleteByPrimaryKey(String id){

    }
    void insert(Account record){

    }
    Account selectByPrimayrKey(String id){

    }
    int updateByPrimaryKey(Account record){

    }
    void transfer(String remitterId, String remitteeId,int money){

    }
}
