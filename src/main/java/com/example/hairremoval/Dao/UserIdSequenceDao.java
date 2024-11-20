package com.example.hairremoval.Dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.UserIdSequence;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

@Dao
@DomaInjectConfig
public interface UserIdSequenceDao {

  //ユーザーIDに基づいてエンティティを取得
  @Select
  UserIdSequence selectById(int userId);

}
