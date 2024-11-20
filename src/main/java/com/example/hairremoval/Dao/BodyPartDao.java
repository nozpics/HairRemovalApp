package com.example.hairremoval.Dao;

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

  //指定されたボディコードで部位情報を取得
  @Select
  BodyPart selectByCord(String bodyCode);

  //新しい脱毛部位をデータベースに挿入する
  //挿入された行数と挿入後のエンティティの状態を取得できる
  @Insert
  int insert(BodyPart bodyPart);

  //既存の脱毛部位情報を更新する
  @Update
  int update(BodyPart bodyPart);

  //名前に基づいて脱毛部位を検索する
  //複数の結果が返される可能性があるためList
  @Select
  List<BodyPart> selectByName(String name);

}
