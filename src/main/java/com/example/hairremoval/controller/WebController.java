package com.example.hairremoval.controller;

import com.example.hairremoval.entity.BodyPart;
import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.entity.NextSchedule;
import com.example.hairremoval.entity.User;
import com.example.hairremoval.service.BodyPartService;
import com.example.hairremoval.service.HairRemovalLogService;
import com.example.hairremoval.service.LogRegisterService;
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
public class WebController {

  @Autowired
  private UserService userService;

  @Autowired
  private NextScheduleService nextScheduleService;

  @Autowired
  private HairRemovalLogService hairRemovalLogService;

  @Autowired
  private BodyPartService bodyPartService;

  @Autowired
  private LogRegisterService logRegisterService;


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
    List<BodyPart> bodyPart = bodyPartService.getBodyPartName();
    model.addAttribute("bodyPart",bodyPart);
    return "logInput";
  }

  /**
   * logRegisterController
   */
  @PostMapping("/logRegister")
  public String registerText(@RequestParam LocalDate date,@RequestParam String bodyPart,@RequestParam LocalDate nextDate,Model model){
    int userId=1;
    int sessionCount =hairRemovalLogService.getSessionCount(userId, bodyPart); //脱毛回数の取得
    model.addAttribute("date",date);
    model.addAttribute("bodyPart",bodyPart);
    model.addAttribute("nextDate",nextDate);
    model.addAttribute("sessionCount",sessionCount);
    return "logRegister";
  }

  /**
   * registrationCompleteController
   */
  @PostMapping("/registrationComplete")
  public String saveRegistration(@RequestParam LocalDate date,@RequestParam String bodyPart,@RequestParam LocalDate nextDate,@RequestParam int sessionCount, Model model){
    logRegisterService.logRegister(date,bodyPart,nextDate,sessionCount); //DB登録処理
    return "registrationComplete";
  }

  @GetMapping("/login")
  public String getLogin(Model model){
    return "login";
  }

  @GetMapping("/accountInput")
  public String getAccountInput(Model model){
    return "accountInput";
  }

  /**
   * accountRegisterController
   */
  @PostMapping("/accountRegister")
  public String accountText(@RequestParam String userName,@RequestParam String passwordHash,Model model){
    model.addAttribute("userName",userName);
    model.addAttribute("passwordHash",passwordHash);
    return "accountRegister";
  }
  /**
   * accountRegistrationCompleteController
   */
  @PostMapping("/accountRegistrationComplete")
  public String saveAccountRegistration(@RequestParam String userName,@RequestParam String passwordHash,Model model){
    int userId=userService.setUserById();//登録するユーザーID
    model.addAttribute("userId",userId);
    model.addAttribute("userName",userName);
    model.addAttribute("passwordHash",passwordHash);
    userService.accountRegister(userId,userName,passwordHash);//DB登録処理
    return "accountRegistrationComplete";
  }
}
