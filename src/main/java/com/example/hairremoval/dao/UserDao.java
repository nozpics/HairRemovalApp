package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.User;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

@Dao
@DomaInjectConfig
public interface UserDao {

  //データベースから全てのユーザー情報を取得する
  @Select
  List<User> selectAll();

  //指定されたユーザーIDでユーザー情報を取得
  @Select
  User selectByID(int userId);

  //ユーザーIDを登録するために現在の最大値を取得する
  @Select
  int selectByMaxID();

  //新しいユーザー情報を挿入するため データベースの行数を表すため戻り値はint
  @Insert(sqlFile = true)
  int insertUser(int userId,String userName,String passwordHash);

  //既存のユーザー情報を更新するため
  @Update(sqlFile = true)
  int updateUser(int userId,String userName,String passwordHash);

}
