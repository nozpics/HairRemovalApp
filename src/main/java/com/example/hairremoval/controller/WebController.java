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
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
   * loginController
   *
   */
  @GetMapping("/login")
  public String getLoginForm(Model model){
    return "login";
  }

  /**
   * homeController
   *
   */
  @GetMapping("/home")
  public String getHome(Model model){
    int userId = userService.getLoggedInUser();
    User user = userService.getUserById(userId);
    model.addAttribute("user",user);
    List<NextSchedule> nextSchedule = nextScheduleService.selectByUserId(userId);
    model.addAttribute("nextSchedule",nextSchedule);
    log.info("userId");
    log.info(String.valueOf(userId));

    return "home";
  }

  /**
   * logListController
   *
   */
  @GetMapping("/logList")
  public String getLogList(Model model){
    int userId = userService.getLoggedInUser();
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
  public String registerText(@RequestParam LocalDate date, @RequestParam String bodyPart, @RequestParam LocalDate nextDate, RedirectAttributes redirectAttributes,Model model) {
    
    if (date.isAfter(nextDate)) {
      redirectAttributes.addFlashAttribute("errorMessage", "次回脱毛日が脱毛日より前になっています。");
      return "redirect:/logInput";
    }
    int userId = userService.getLoggedInUser();
    int sessionCount = hairRemovalLogService.getSessionCount(userId, bodyPart);

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

  @GetMapping("/accountInput")
  public String getAccountInput(Model model){
    return "accountInput";
  }

  /**
   * accountRegisterController
   */
  @PostMapping("/accountRegister")
  public String accountText(@RequestParam String userName,@RequestParam String password,Model model){
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    return "accountRegister";
  }
  /**
   * accountRegistrationCompleteController
   */
  @PostMapping("/accountRegistrationComplete")
  public String saveAccountRegistration(@RequestParam String userName,@RequestParam String password,Model model){
    int userId = userService.accountRegister(userName,password);//DB登録処理
    model.addAttribute("userId",userId);
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    return "accountRegistrationComplete";
  }

  /**
   * accountUpdateInputController
   */
  @GetMapping("/accountUpdateInput")
public String getAccountUpdateInput(Model model){
  return "accountUpdateInput";
}

  @PostMapping("/accountUpdateCheck")
  public String checkAccountUpdate(@RequestParam String userName,@RequestParam String password,Model model){
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    return "accountUpdateCheck";
  }

  @PostMapping("/accountUpdateComplete")
  public String saveAccountUpdate(@RequestParam String userName,@RequestParam String password,Model model){
    int userId = userService.getLoggedInUser();
    model.addAttribute("userId",userId);
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    userService.saveUserUpdate(userId,userName,password);
    return "accountUpdateComplete";
  }
}