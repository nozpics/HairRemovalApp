package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.BodyPart;
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

  @Select
  LocalDate getDate(int userId,String bodyCode);

  //部位コードにもとづく回数を取得
  @Select
  int selectSession(int userId,String bodyCode);

  //新しい履歴をデータベースに挿入
  @Insert(sqlFile = true)
  int insertLog(int userId,LocalDate date, String bodyCode,int sessionCount);

}
