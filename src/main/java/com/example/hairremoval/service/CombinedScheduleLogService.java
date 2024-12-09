package com.example.hairremoval.service;

//import com.example.hairremoval.dto.CombinedScheduleLog;
import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//@Service
//public class CombinedScheduleLogService {
//  @Autowired
//  private NextScheduleService nextScheduleService;
//  @Autowired
//  private HairRemovalLogService hairRemovalLogService;
//
//  public List<CombinedScheduleLog> getCombinedScheduleLogsSortedByDate(int userId) {
//    List<NextSchedule> nextSchedules = nextScheduleService.getNextScheduleSortedByDate(userId);
//    List<HairRemovalLog> hairRemovalLogs = hairRemovalLogService.getHairRemovalLogByUserID(userId);
//
//    //部位ごとの最新のセッション回数を追跡
//    Map<String, Integer> bodyCodeToSessionCount = new HashMap<>();
//    for (HairRemovalLog log : hairRemovalLogs) {
//      bodyCodeToSessionCount.put(log.getBodyCode(),
//          Math.max(bodyCodeToSessionCount.getOrDefault(log.getBodyCode(), 0), log.getSessionCount()));
//    }
//
//    //次回予定、部位、回数をcombinedに設定し、最新の回数に1を加える
//    List<CombinedScheduleLog> combinedLogs = new ArrayList<>();
//    for (NextSchedule schedule : nextSchedules) {
//      CombinedScheduleLog combined = new CombinedScheduleLog();
//      combined.setNextDate(schedule.getNextDate());
//      combined.setBodyCode(schedule.getBodyCode());
//      combined.setSessionCount(bodyCodeToSessionCount.getOrDefault(schedule.getBodyCode(), 0) + 1);
//      combinedLogs.add(combined);
//    }
//
//    //次回の予定日で並べ替えて結果をreturnする
//    combinedLogs.sort(Comparator.comparing(CombinedScheduleLog::getNextDate));
//    return combinedLogs;
//  }
//}
