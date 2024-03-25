package dao;

import domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    int deleteByPrimaryKey(String id);

    int insert(Account record);

    Account selectByPrimayrKey(String id);

    int updateByPrimaryKey(Account record);
}
