package com.example.hairremoval.service;

import com.example.hairremoval.dao.NextScheduleDao;
import com.example.hairremoval.entity.NextSchedule;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NextScheduleService {

    @Autowired
    private NextScheduleDao nextScheduleDao;

    public List<NextSchedule> getAllNextSchedule() {
      return nextScheduleDao.selectAll();
    }

    public List<NextSchedule> getAllNextScheduleSortedByDate(){
      List<NextSchedule> schedules = getAllNextSchedule();
      schedules.sort(Comparator.comparing(NextSchedule::getNextDate));
      return schedules;
    }
  }
