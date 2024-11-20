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

  //新しいユーザー情報を挿入するため データベースの行数を表すため戻り値はint
  @Insert
  int insert(User user);

  //既存のユーザー情報を更新するため
  @Update
  int update(User user);

}
