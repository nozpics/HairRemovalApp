package com.example.hairremoval.service;

import com.example.hairremoval.dao.NextScheduleDao;
import com.example.hairremoval.entity.NextSchedule;
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
  }
