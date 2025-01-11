package com.example.hairremoval.service;


import com.example.hairremoval.dao.HairRemovalLogDao;
import com.example.hairremoval.entity.HairRemovalLog;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HairRemovalLogService {
  @Autowired
  private HairRemovalLogDao hairRemovalLogDao;

  public List<HairRemovalLog> getHairRemovalLogByUserID(int userId) {
    return hairRemovalLogDao.selectByUserId(userId);
  }

  public int getSessionCount(int userId,String bodyCode){
    return hairRemovalLogDao.selectSession(userId,bodyCode);
  }

  public LocalDate getLogDate(int userId,String bodyCode){
    return hairRemovalLogDao.getDate(userId,bodyCode);
  }
}
