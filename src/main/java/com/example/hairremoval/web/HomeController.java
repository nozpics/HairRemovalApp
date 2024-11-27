package com.example.hairremoval.web;

import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
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
  private NextScheduleService nextScheduleService;

  @Autowired
  private HairRemovalLogService hairRemovalLogService;

  @GetMapping("/home")
  public String get(Model model){
//    User user = new User();
//    user.setUserName(user.getUserName());
//    log.info("aaaa");
//    log.info(user.getUserName());
//    model.addAttribute("user",user);
    List<User> users = userService.getAllUsers();
      User user = users.get(0);
      model.addAttribute("user",user);

    List<NextSchedule> nextSchedules = nextScheduleService.getAllNextSchedule();
//      NextSchedule nextSchedule = nextSchedules.get(0);
      model.addAttribute("nextSchedules",nextSchedules);
//      model.addAttribute("bodyCode",nextSchedule.getBodyCode());


    List<HairRemovalLog> hairRemovalLogs = hairRemovalLogService.getAllHairRemovalLog();
//      HairRemovalLog hairRemovalLog = hairRemovalLogs.get(0);
      model.addAttribute("hairRemovalLogs",hairRemovalLogs);

    return "home";
  }
}
