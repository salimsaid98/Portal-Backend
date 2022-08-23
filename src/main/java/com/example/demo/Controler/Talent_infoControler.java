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
   public ResponseEntity getll(){
        List<Talent_infoDTO> list = new ArrayList<>();
        Talent_infoDTO talent_infoDTO = new Talent_infoDTO();
        talent_infoDTO = null;
        for(Talent_info talent_info:talent_infoService.getTalent_infos()){
            talent_infoDTO = modelMapper.map(talent_info, Talent_infoDTO.class);
            talent_infoDTO.setEx_id(talent_info.getExpert().getEx_id());
            list.add(talent_infoDTO);
        }
        return ResponseEntity.ok().body(list);
   }
    @PostMapping("/")
    public ResponseEntity save(@RequestBody Talent_infoDTO talent_infoDTO){
        return ResponseEntity.ok().body(talent_infoService.save(talent_infoDTO));

    }

    
}
