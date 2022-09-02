package com.example.demo.Controler;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TalentDTO;
import com.example.demo.Model.Expert;
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
    @GetMapping("{id}")
    public ResponseEntity<TalentDTO> getbyid(@PathVariable Long id){
            Talent talent = talentService.getTalent(id);
            TalentDTO talentDTO = modelMapper.map(talent, TalentDTO.class);
            return ResponseEntity.ok().body(talentDTO);
    }
    @DeleteMapping("{id}")
    public ResponseEntity <TalentDTO> delete(@PathVariable long id){
        Talent talent = talentService.delete(id);
        TalentDTO talentDTO = modelMapper.map(talent, TalentDTO.class);
        return ResponseEntity.ok().body(talentDTO);
    }

    @GetMapping("/search{name}")
        public List<Talent> getallSpeci(@PathVariable String name){
            return talentService.getsp(name);
        }
        @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody TalentDTO talentDTO){
           Talent talent =  modelMapper.map(talentDTO, Talent.class);
           Talent talent2 = talentService.edit(id, talent);

           TalentDTO talentDTO2 = modelMapper.map(talent2, TalentDTO.class);

           return ResponseEntity.ok().body(talentDTO2);

    }
}
