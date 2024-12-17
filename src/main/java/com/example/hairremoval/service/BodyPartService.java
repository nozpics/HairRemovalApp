package com.example.hairremoval.service;

import com.example.hairremoval.dao.BodyPartDao;
import com.example.hairremoval.entity.BodyPart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyPartService {
  @Autowired
  private BodyPartDao bodyPartDao;

  public List<BodyPart> getBodyPartName(){
    return bodyPartDao.selectAll();
  }

}
