package com.example.hairremoval.service;

import com.example.hairremoval.dao.NextScheduleDao;
import com.example.hairremoval.entity.NextSchedule;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 次回予定に関するサービスクラス
 */
@Service
public class NextScheduleService {

    @Autowired
    private NextScheduleDao nextScheduleDao;

  /**
   * 部位ごとの最新の次回予定日と、部位の名前、次回の脱毛回数を取得し日付順に並び替える
   * @param userId ユーザーID
   * @return 取得した情報を日付順に並び替えて返す
   */
  public List<NextSchedule> selectByUserId(int userId){
      return nextScheduleDao.selectByUserId(userId);
    }
  }
