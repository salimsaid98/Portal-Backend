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
        TalentDTO talentDTO2 = new TalentDTO();
        talentDTO2.setExpert(talentDTO.getExpert());
        Talent talent = modelMapper.map(talentDTO2, Talent.class);

        return ResponseEntity.ok(talentService.save(talent));
    }
    @GetMapping
    public ResponseEntity getall(){
        List<TalentDTO> list = new ArrayList<>();
        TalentDTO talentDTO = new TalentDTO();
        for(Talent talent : talentService.getTalents()){
            talentDTO = modelMapper.map(talent, TalentDTO.class);
            list.add(talentDTO);
        }
        return ResponseEntity.ok(list);
    }
}
