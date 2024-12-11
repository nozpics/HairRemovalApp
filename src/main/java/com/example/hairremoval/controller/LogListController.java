package com.example.hairremoval.controller;

import com.example.hairremoval.entity.HairRemovalLog;
import com.example.hairremoval.service.HairRemovalLogService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LogListController {

  @Autowired
  private HairRemovalLogService hairRemovalLogService;

  @GetMapping("/logList")
  public String get(@RequestParam int userId, Model model){
    List<HairRemovalLog> hairRemovalLog = hairRemovalLogService.getHairRemovalLogByUserID(userId);
    model.addAttribute("hairRemovalLog",hairRemovalLog);
    return "logList";
  }
}
