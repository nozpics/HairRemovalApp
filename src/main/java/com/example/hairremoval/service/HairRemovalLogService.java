package com.example.hairremoval.service;


import com.example.hairremoval.dao.HairRemovalLogDao;
import com.example.hairremoval.entity.HairRemovalLog;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 脱毛履歴に関するサービスクラス
 */
@Service
public class HairRemovalLogService {
  @Autowired
  private HairRemovalLogDao hairRemovalLogDao;

  /**
   * 指定されたユーザーIDごとの履歴を取得する
   * @param userId ユーザーID
   * @return 取得した履歴
   */
  public List<HairRemovalLog> getHairRemovalLogByUserID(int userId) {
    return hairRemovalLogDao.selectByUserId(userId);
  }

  /**
   * 指定された脱毛部位の脱毛回数を取得する
   * @param userId ユーザーID
   * @param bodyCode 脱毛部位コード
   * @return 脱毛回数
   */
  public int getSessionCount(int userId,String bodyCode){
    return hairRemovalLogDao.selectSession(userId,bodyCode);
  }

  /**
   * 指定された脱毛部位の最新の日付を取得する
   * @param userId ユーザーID
   * @param bodyCode 脱毛部位コード
   * @return 最新の日付
   */
  public LocalDate getLogDate(int userId,String bodyCode){
    return hairRemovalLogDao.getDate(userId,bodyCode);
  }
}
