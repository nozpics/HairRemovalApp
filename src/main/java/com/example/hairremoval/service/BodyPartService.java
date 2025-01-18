package com.example.hairremoval.service;

import com.example.hairremoval.dao.BodyPartDao;
import com.example.hairremoval.entity.BodyPart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 脱毛部位の名前と脱毛部位コードに関するサービスクラス
 */
@Service
public class BodyPartService {
  @Autowired
  private BodyPartDao bodyPartDao;

  public List<BodyPart> getBodyPartName(){
    return bodyPartDao.selectAll();
  }

  /**
   * 脱毛部位の名前の脱毛部位コードを取得する
   * @param bodyPart　脱毛部位の名前
   * @return 脱毛部位コード
   */
  public String getBodyCode(String bodyPart){
    return bodyPartDao.selectByCode(bodyPart);
  }


}
