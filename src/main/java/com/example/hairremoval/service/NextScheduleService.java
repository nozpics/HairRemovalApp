package com.example.hairremoval.service;

import com.example.hairremoval.dao.NextScheduleDao;
import com.example.hairremoval.entity.NextSchedule;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NextScheduleService {

    @Autowired
    private NextScheduleDao nextScheduleDao;

    public List<NextSchedule> selectByUserId(int userId){
      return nextScheduleDao.selectByUserId(userId);
    }

//    public List<NextSchedule> getNextScheduleSortedByDate(int userId){
//      List<NextSchedule> schedules = nextScheduleDao.selectByUserId(userId);
//      schedules.sort(Comparator.comparing(NextSchedule::getNextDate));
//      return schedules;
//    }
  }
