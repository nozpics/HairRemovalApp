package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

@Dao
@DomaInjectConfig
public interface UserDao {

  //指定されたユーザーIDでユーザー情報を取得
  @Select
  User selectByID(int userId);

  //新しいユーザー情報を挿入するため データベースの行数を表すため戻り値はint
  @Insert(sqlFile = true)
  int insertUser(int userId,String userName,String passwordHash);

  //既存のユーザー情報を更新するため
  @Update(sqlFile = true)
  int updateUser(int userId,String userName,String passwordHash);

}
