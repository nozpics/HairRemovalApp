package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.HairRemovalLog;
import java.time.LocalDate;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

@Dao
@DomaInjectConfig
public interface HairRemovalLogDao {

  //データベースから全ての履歴情報を取得する
  @Select
  List<HairRemovalLog> selectAll();

  //特定のユーザーIDに関する全ての履歴を取得
  @Select
  List<HairRemovalLog> selectByUserId(int userId);

  //主キーに基づいて特定の履歴を取得
  @Select
  HairRemovalLog selectById(int userId, String bodyCode, int sessionCount);

  //新しい履歴をデータベースに挿入
  @Insert(sqlFile = true)
  List<HairRemovalLog> insertLog(LocalDate date, String name,LocalDate nextDate);
  int insert(HairRemovalLog hairRemovalLog);

}
