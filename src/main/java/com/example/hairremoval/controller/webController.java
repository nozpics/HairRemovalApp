package com.example.hairremoval.controller;

import com.example.hairremoval.entity.BodyPart;
import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
import com.example.hairremoval.entity.User;
import com.example.hairremoval.service.BodyPartService;
import com.example.hairremoval.service.HairRemovalLogService;
import com.example.hairremoval.service.NextScheduleService;
import com.example.hairremoval.service.UserService;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class webController {

  @Autowired
  private UserService userService;

  @Autowired
  private NextScheduleService nextScheduleService;

  @Autowired
  private HairRemovalLogService hairRemovalLogService;

  @Autowired
  private BodyPartService bodyPartService;

  /**
   * homeController
   *
   */
  @GetMapping("/home")
  public String getHome(Model model){
    int userId=1;
    User user = userService.getUserById(userId);
    model.addAttribute("user",user);

    List<NextSchedule> nextSchedule = nextScheduleService.selectByUserId(userId);
    model.addAttribute("nextSchedule",nextSchedule);

    return "home";
  }

  /**
   * logListController
   *
   */
  @GetMapping("/logList")
  public String getLogList(Model model){
    int userId=1;
    List<HairRemovalLog> hairRemovalLog = hairRemovalLogService.getHairRemovalLogByUserID(userId);
    model.addAttribute("hairRemovalLog",hairRemovalLog);
    return "logList";
  }

  /**
   * logInputController
   */
  @GetMapping("/logInput")
  public String getLogInput(Model model){
    int userId=1;
    List<BodyPart> bodyPart = bodyPartService.getBodyPartName();
    model.addAttribute("bodyPart",bodyPart);
    return "logInput";
  }

  /**
   * logRegisterController
   */
//  @GetMapping("/logRegister")
//  public String getLogRegister(Model model){
//    int userId=1;
//    return "logRegister";
//  }
  @PostMapping("/logRegister")
  public String registerText(@RequestParam LocalDate date,@RequestParam String bodyPart,@RequestParam LocalDate nextDate,Model model){
    model.addAttribute("date",date);
    model.addAttribute("bodyPart",bodyPart);
    model.addAttribute("nextDate",nextDate);
    return "logRegister";
  }

  /**
   * registrationCompleteController
   */
  @GetMapping("/registrationComplete")
  public String getRegistrationComplete(Model model){
    int userId=1;
    return "registrationComplete";
  }
  @PostMapping("/registrationComplete")
  public String saveRegistration(@RequestParam LocalDate date,@RequestParam String name,@RequestParam LocalDate nextDate,Model model){
    hairRemovalLogService.registerInsertLog(date, name, nextDate);
    return "registrationComplete";
  }
//
//  @PostMapping("/logConfirm")
//  public String insertLog(@RequestParam LocalDate date, @RequestParam String name, @RequestParam LocalDate nextDate, Model model){
//
//    hairRemovalLogService.registerInsertLog(date, name, nextDate);
//    return "logConfirm";
//
//  }
}
