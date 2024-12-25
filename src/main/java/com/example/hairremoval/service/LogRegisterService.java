package com.example.hairremoval.service;

import com.example.hairremoval.dao.BodyPartDao;
import com.example.hairremoval.dao.HairRemovalLogDao;
import com.example.hairremoval.dao.NextScheduleDao;
import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 履歴を登録するためのサービスクラス
 */
@Service
public class LogRegisterService {

  @Autowired
  private HairRemovalLogDao hairRemovalLogDao;
  @Autowired
  private BodyPartDao bodyPartDao;
  @Autowired
  private NextScheduleDao nextScheduleDao;

  public void logRegister(LocalDate date, String bodyPart,LocalDate nextDate,int sessionCount) {
    HairRemovalLog hairRemovalLog = new HairRemovalLog();
    NextSchedule nextSchedule = new NextSchedule();
    int userId = 1;

    //部位コードを設定
    String bodyCode = bodyPartDao.selectByCode(bodyPart);

    //DBに登録
    hairRemovalLogDao.insertLog(userId,date,bodyCode,sessionCount);
    nextScheduleDao.insertSchedule(userId,bodyCode,nextDate);
  }
}
