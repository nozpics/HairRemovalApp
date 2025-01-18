package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.BodyPart;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

@Dao
@DomaInjectConfig
public interface BodyPartDao {

  //データベースから全ての部位情報を取得する
  @Select
  List<BodyPart> selectAll();

  //指定された部位でボディコードを取得
  @Select
  String selectByCode(String bodyPart);

  //新しい脱毛部位をデータベースに挿入する
  //挿入された行数と挿入後のエンティティの状態を取得できる
  @Insert(sqlFile = true)
  int insert(BodyPart bodyPart);

  //既存の脱毛部位情報を更新する
  @Update(sqlFile = true)
  int update(BodyPart bodyPart);

}
