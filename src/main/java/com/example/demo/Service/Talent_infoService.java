package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.demo.DTO.TalentDTO;
import com.example.demo.DTO.Talent_infoDTO;
import com.example.demo.Model.Expert;
import com.example.demo.Model.Talent;
import com.example.demo.Model.Talent_info;
import com.example.demo.exception.Datanotfound;
import com.example.demo.repository.Talent_infoRepo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Data
@Service
@Slf4j
public class Talent_infoService {
    private final Talent_infoRepo talent_infoRepo;
@Autowired
    private final  ModelMapper modelMapper;

  
public Talent_info save(Talent_infoDTO talent_infoDTO){
    // log.info(talent_infoDTO.toString());
    Talent talent = new Talent();
    Expert expert = new Expert();
    expert.setEx_id(talent_infoDTO.getEx_id());
    talent.setTalent_id(talent_infoDTO.getTalent_id());
    Talent_info talent_info = modelMapper.map(talent_infoDTO, Talent_info.class);
    talent_info.setExpert(expert);
    talent_info.setTalent(talent);
    // log.info(talent_info.toString());
    return talent_infoRepo.save(talent_info);
}

 public List<Talent_info> getTalent_infos(){
        return StreamSupport.stream(talent_infoRepo.findAll().spliterator(),false).
         collect(Collectors.toList());
}


public Talent_info getTalent_info(Long id){
    return talent_infoRepo.findById(id).orElseThrow(()-> new Datanotfound(id));
}

public Talent_info delete(Long id){
    Talent_info talent_info = getTalent_info(id);
    talent_infoRepo.delete(talent_info);
    return talent_info;
}




}
