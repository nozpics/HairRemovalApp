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
import com.example.hairremoval.utils.MessageUtils;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
   * ログイン画面を表示するメソッド
   * @return ログイン画面
   */
  @GetMapping("/login")
  public String getLoginForm(){
    return "login";
  }

  /**
   * 脱毛管理画面を表示するメソッド
   * @param model ビューに渡すデータを格納する
   * @return 脱毛管理画面
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
   * 脱毛履歴確認画面を表示するメソッド
   * @param model ビューに渡すデータを格納する
   * @return 脱毛履歴確認画面
   */
  @GetMapping("/logList")
  public String getLogList(Model model){
    int userId = userService.getLoggedInUser();
    List<HairRemovalLog> hairRemovalLog = hairRemovalLogService.getHairRemovalLogByUserID(userId);
    model.addAttribute("hairRemovalLog",hairRemovalLog);
    return "logList";
  }

  /**
   * 脱毛日入力画面を表示するメソッド
   * @param model ビューに渡すデータを格納する
   * @return 脱毛日入力画面
   */
  @GetMapping("/logInput")
  public String getLogInput(Model model){
    //脱毛部位のリストを作成
    List<BodyPart> bodyPart = bodyPartService.getBodyPartName();
    model.addAttribute("bodyPart",bodyPart);
    return "logInput";
  }

  /**
   * 脱毛日入力画面からPOSTされた情報を処理し、脱毛日登録画面に表示するメソッド
   * 入力された情報をチェックし、エラーがある場合はリダイレクトする
   * @param date 入力された脱毛日
   * @param bodyPart 入力された脱毛部位
   * @param nextDate 入力された次回予定日
   * @param redirectAttributes リダイレクト先に一時的なメッセージを渡す
   * @param model ビューに渡すデータを格納する
   * @return 脱毛日登録画面、またはエラー時にリダイレクトする脱毛日入力画面
   */
  @PostMapping("/logRegister")
  public String registerText(@RequestParam LocalDate date, @RequestParam String bodyPart, @RequestParam LocalDate nextDate, RedirectAttributes redirectAttributes,Model model) {

    int userId = userService.getLoggedInUser();
    String bodyCode = bodyPartService.getBodyCode(bodyPart);

    // 脱毛回数を取得
    int sessionCount = hairRemovalLogService.getSessionCount(userId, bodyPart);

    // 入力された脱毛日が次回予定日より後の日付になっている場合のエラーチェック
    if (date.isAfter(nextDate)) {
      redirectAttributes.addFlashAttribute("errorMessage", MessageUtils.getMessage("nextDateErrorMessage"));
      return "redirect:/logInput";
    }
    // 入力された脱毛日と次回予定日が同じ日付になっている場合のエラーチェック
    if (date.isEqual(nextDate)){
      redirectAttributes.addFlashAttribute("errorMessage",MessageUtils.getMessage("nextDateEqualErrorMessage"));
      return "redirect:/logInput";
    }
    // 入力された脱毛日が履歴より前の日付になっている場合のエラーチェック
    if (sessionCount != 0) {
      LocalDate logDate = hairRemovalLogService.getLogDate(userId,bodyCode);
      if(date.isBefore(logDate)){
        redirectAttributes.addFlashAttribute(
          "errorMessage", MessageUtils.getMessage("dateLogErrorMessage"));
      return "redirect:/logInput";
    }
    }
    model.addAttribute("date",date);
    model.addAttribute("bodyPart",bodyPart);
    model.addAttribute("nextDate",nextDate);
    model.addAttribute("sessionCount",sessionCount+1);
    return "logRegister";
  }

  /**
   * 脱毛日登録画面からPOSTされた情報をデータベースに登録し、脱毛日登録完了画面を表示するメソッド
   * @param date 入力された脱毛日
   * @param bodyPart 入力された脱毛部位
   * @param nextDate 入力された次回予定日
   * @param sessionCount 部位ごとの脱毛回数
   * @return 脱毛日登録完了画面
   */
  @PostMapping("/registrationComplete")
  public String saveRegistration(@RequestParam LocalDate date,@RequestParam String bodyPart,@RequestParam LocalDate nextDate,@RequestParam int sessionCount){
    //DB登録処理
    logRegisterService.logRegister(date,bodyPart,nextDate,sessionCount);
    return "registrationComplete";
  }

  /**
   * アカウント登録画面を表示するメソッド
   * @return アカウント登録画面
   */
  @GetMapping("/accountInput")
  public String getAccountInput(){
    return "accountInput";
  }

  /**
   * アカウント登録画面からPOSTされた情報を処理し、アカウント登録確認画面に表示するメソッド
   * @param userName 入力されたユーザー名
   * @param password 入力されたパスワード
   * @param model ビューに渡すデータを格納する
   * @return アカウント登録確認画面
   */
  @PostMapping("/accountRegister")
  public String accountText(@RequestParam String userName,@RequestParam String password,Model model){
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    return "accountRegister";
  }

  /**
   * アカウント登録確認画面からPOSTされた情報をデータベースに登録し、アカウント登録完了画面を表示するメソッド
   * @param userName 入力されたユーザー名
   * @param password 入力されたパスワード
   * @param model ビューに渡すデータを格納する
   * @return アカウント登録完了画面
   */
  @PostMapping("/accountRegistrationComplete")
  public String saveAccountRegistration(@RequestParam String userName,@RequestParam String password,Model model){
    //パスワードをハッシュ化後、DB登録処理し、ユーザーIDを取得
    int userId = userService.accountRegister(userName,password);
    model.addAttribute("userId",userId);
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    return "accountRegistrationComplete";
  }

  /**
   * アカウント変更画面を表示するメソッド
   * @return アカウント変更画面
   */
  @GetMapping("/accountUpdateInput")
  public String getAccountUpdateInput(){
  return "accountUpdateInput";
}

  /**
   * アカウント変更画面からPOSTされた情報を処理し、アカウント変更確認画面に表示するメソッド
   * @param userName 入力されたユーザー名
   * @param password 入力されたパスワード
   * @param model ビューに渡すデータを格納する
   * @return アカウント変更確認画面
   */
  @PostMapping("/accountUpdateCheck")
  public String checkAccountUpdate(@RequestParam String userName,@RequestParam String password,Model model){
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    return "accountUpdateCheck";
  }

  /**
   * アカウント変更確認画面からPOSTされた情報をデータベースに登録し、アカウント変更完了画面を表示するメソッド
   * @param userName 入力されたユーザー名
   * @param password 入力されたパスワード
   * @param model ビューに渡すデータを格納する
   * @return アカウント変更完了画面
   */
  @PostMapping("/accountUpdateComplete")
  public String saveAccountUpdate(@RequestParam String userName,@RequestParam String password,Model model){
    //現在ログインしているユーザーIDを取得
    int userId = userService.getLoggedInUser();

    model.addAttribute("userId",userId);
    model.addAttribute("userName",userName);
    model.addAttribute("password",password);
    //入力された内容でデータベース更新処理
    userService.saveUserUpdate(userId,userName,password);
    return "accountUpdateComplete";
  }
}