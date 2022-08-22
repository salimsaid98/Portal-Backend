package com.example.demo.Controler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Talent_infoDTO;
import com.example.demo.Model.Talent;
import com.example.demo.Model.Talent_info;
import com.example.demo.Service.Talent_infoService;

@RestController
@RequestMapping("api/Talent_info")
public class Talent_infoControler {
   @Autowired
    private Talent_infoService talent_infoService;
    @Autowired
    private ModelMapper modelMapper;
@GetMapping("/")
    public  List<Talent_info> gTalent_infos(){
        return talent_infoService.getTalent_infos();
    }
    @PostMapping("/")
    public ResponseEntity<Talent_info> save(@RequestBody Talent_infoDTO talent_infoDTO){
        Talent_info talent_info2 = new Talent_info();
        talent_info2.setExpert(talent_infoDTO.getExpert());
        talent_info2.setTalent(talent_infoDTO.getTalent());
        Talent_info talent_info = modelMapper.map(talent_info2, Talent_info.class);
        return ResponseEntity.ok().body(talent_infoService.save(talent_info));

    }

    
}
