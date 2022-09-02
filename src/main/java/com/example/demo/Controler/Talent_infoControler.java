package com.example.demo.Controler;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TalentDTO;
import com.example.demo.DTO.Talent_infoDTO;
import com.example.demo.DTO.Talent_infoRespondDTO;
import com.example.demo.Model.Expert;
import com.example.demo.Model.Talent;
import com.example.demo.Model.Talent_info;
import com.example.demo.Service.Talent_infoService;
@CrossOrigin
@RestController
@RequestMapping("api/Talent_info")
public class Talent_infoControler {
   @Autowired
    private Talent_infoService talent_infoService;
    @Autowired
    private ModelMapper modelMapper;
@GetMapping("/")
   public ResponseEntity getll(){
    //    List<Talent_infoDTO> list = new ArrayList<>();
        // Expert expert = new Expert();
        // Talent talent = new Talent();
        
        // for(Talent_info talent_info:talent_infoService.getTalent_infos()){
        //         // talent_info.setExpert(expert);
        //         // talent_info.setTalent(talent);
        //        Talent_infoDTO talent_infoDTO =  modelMapper.map(talent_info, Talent_infoDTO.class);
        //         list.add(talent_infoDTO);
        // }
        // return ResponseEntity.ok().body(list);

    //     List<Talent_info> list = new ArrayList<>();
    //     for(Talent_info talent_info:talent_infoService.getTalent_infos()){
    //             list.add(talent_info);
    //     }
        
    //    return ResponseEntity.ok().body(list);
    
    List<Talent_infoRespondDTO> list = new ArrayList<>();
    Talent_infoRespondDTO talent_infoRespondDTO = new Talent_infoRespondDTO();
    List<Talent_info> talent_infos = talent_infoService.getTalent_infos();
    for(Talent_info talent_info :talent_infos){
         talent_infoRespondDTO = modelMapper.map(talent_info, Talent_infoRespondDTO.class);
         
        talent_infoRespondDTO.setF_name(talent_info.getExpert().getF_name());
        talent_infoRespondDTO.setS_name(talent_info.getExpert().getS_name());
        talent_infoRespondDTO.setL_name(talent_info.getExpert().getL_name());
        talent_infoRespondDTO.setEmail(talent_info.getExpert().getEmail());;
        talent_infoRespondDTO.setGander(talent_info.getExpert().getGander());
        talent_infoRespondDTO.setAddress(talent_info.getExpert().getAddress());
        talent_infoRespondDTO.setStatus(talent_info.getExpert().getStatus());
        talent_infoRespondDTO.setPhone(talent_info.getExpert().getPhone());
        talent_infoRespondDTO.setDob(talent_info.getExpert().getDob());
        talent_infoRespondDTO.setSpecialization(talent_info.getTalent().getSpecialization());
        talent_infoRespondDTO.setCertification(talent_info.getTalent().getCertification());
        talent_infoRespondDTO.setWorkexp(talent_info.getTalent().getWorkexp());
        talent_infoRespondDTO.setBiography(talent_info.getTalent().getBiography());
        list.add(talent_infoRespondDTO);
    }
    return ResponseEntity.ok().body(list);

   }
    @PostMapping("/")
    public ResponseEntity save(@RequestBody Talent_infoDTO talent_infoDTO){
        return ResponseEntity.ok().body(talent_infoService.save(talent_infoDTO));


    }

    
}
