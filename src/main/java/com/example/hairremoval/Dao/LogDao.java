package com.example.hairremoval.Dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.Log;
import java.time.LocalDate;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

@Dao
@DomaInjectConfig
public interface LogDao {

  //データベースから全ての履歴情報を取得する
  @Select
  List<Log> selectAll();

  //特定のユーザーIDに関する全ての履歴を取得
  @Select
  List<Log> selectByUserId(int userId);

  //主キーに基づいて特定の履歴を取得
  @Select
  Log selectById(int userId, String bodyCode, int sessionCount);

  //新しい履歴をデータベースに挿入
  @Insert
  int insert(Log log);

}
