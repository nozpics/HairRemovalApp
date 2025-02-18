package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.UserIdSequence;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

@Dao
@DomaInjectConfig
public interface UserIdSequenceDao {

  //ユーザーIDに基づいてエンティティを取得
  @Select
  int selectById();

  //ユーザーIDを登録
  @Insert
  int setById(UserIdSequence userIdSequence);
}
