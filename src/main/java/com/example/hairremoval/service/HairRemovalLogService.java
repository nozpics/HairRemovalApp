package com.example.hairremoval.service;


import com.example.hairremoval.dao.HairRemovalLogDao;
import com.example.hairremoval.dao.NextScheduleDao;
import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HairRemovalLogService {
  @Autowired
  private HairRemovalLogDao hairRemovalLogDao;

  public List<HairRemovalLog> getAllHairRemovalLog() {
    return hairRemovalLogDao.selectAll();
  }
}
