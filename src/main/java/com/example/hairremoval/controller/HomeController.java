package com.example.hairremoval.controller;

//import com.example.hairremoval.dto.CombinedScheduleLog;
import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
//import com.example.hairremoval.service.CombinedScheduleLogService;
import com.example.hairremoval.service.HairRemovalLogService;
import com.example.hairremoval.service.NextScheduleService;
import com.example.hairremoval.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.hairremoval.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Webコントローラ
 *
 */
@Controller
@Slf4j
public class HomeController {

  /**
   * 脱毛管理画面のコントローラ
   *
   */
  @Autowired
  private UserService userService;

  @Autowired
  private  NextScheduleService nextScheduleService;

//  @Autowired
//  private CombinedScheduleLogService combinedScheduleLogService;

  @GetMapping("/home")
  public String get(@RequestParam int userId, Model model){

      User user = userService.getUserById(userId);
      model.addAttribute("user",user);

      List<NextSchedule> nextSchedule = nextScheduleService.selectByUserId(userId);
      model.addAttribute("nextSchedule",nextSchedule);

      //List<CombinedScheduleLog> combinedLogs = combinedScheduleLogService.getCombinedScheduleLogsSortedByDate(userId);
      //model.addAttribute("combinedLogs",combinedLogs);

    return "home";
  }
}
