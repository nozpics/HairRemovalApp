package com.example.hairremoval.Dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.UserIdSequence;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

@Dao
@DomaInjectConfig
public interface UserIdSequenceDao {
//UserIdSequenceは、自動でユーザーIDが生成されるため、@Insertはいらないかな？

  //ユーザーIDに基づいてエンティティを取得
  @Select
  UserIdSequence selectById(int userId);

  //次のユーザーIDを取得するためにメソッドが別で必要？？
//  @Select
//  int getNextUserId();
}
