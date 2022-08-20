package com.example.demo.Controler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TalentDTO;
import com.example.demo.Model.Talent;
import com.example.demo.Service.TalentService;

@RestController
@RequestMapping("api/talent")
public class TalentControler {
@Autowired
    private ModelMapper modelMapper;
@Autowired
    private TalentService talentService;

    @PostMapping("/")
    public ResponseEntity save(@RequestBody TalentDTO talentDTO){
        
        Talent talent = modelMapper.map(talentDTO, Talent.class);

        return ResponseEntity.ok(talentService.save(talent));
    }
}
