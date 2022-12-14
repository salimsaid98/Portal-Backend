package com.example.demo.Controler;

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

import com.example.demo.DTO.ExpertDTO;
import com.example.demo.DTO.ExpertDTOresponse;
import com.example.demo.Model.Expert;
import com.example.demo.Service.ExpertService;
import com.example.demo.Service.TalentService;

@RestController
@RequestMapping("api/expert")
public class ExpertControler {
@Autowired
    private ModelMapper modelMapper;
@Autowired
    private ExpertService expertService;
    @Autowired
    private TalentService talentService;
    @PostMapping("/")
    public ResponseEntity save(@RequestBody ExpertDTO expertDTO){
        Expert expert = modelMapper.map(expertDTO, Expert.class);
        return ResponseEntity.ok(expertService.save(expert));
    }
   @GetMapping("/")
   public ResponseEntity getall(){
    List<ExpertDTOresponse> list = new ArrayList<>();
    ExpertDTOresponse expertDTOresponse = new ExpertDTOresponse();
     expertDTOresponse = null;
     for(Expert expert2 : expertService.getExperts()){
        expertDTOresponse = modelMapper.map(expert2, ExpertDTOresponse.class);
        list.add(expertDTOresponse);
     }   
        return ResponseEntity.ok(list);

   }
   @GetMapping("{id}")
   public ResponseEntity<ExpertDTO> getbyId(@PathVariable Long id){
           Expert expert = expertService.getExpert(id);
           ExpertDTO expertDTO = modelMapper.map(expert, ExpertDTO.class);
           return ResponseEntity.ok().body(expertDTO);
   }

   @DeleteMapping("{id}")
   public ResponseEntity<ExpertDTO> delete(@PathVariable Long id){
        Expert expert = expertService.delete(id);
        ExpertDTO expertDTO = modelMapper.map(expert, ExpertDTO.class);
        return ResponseEntity.ok().body(expertDTO);
   }
   @PutMapping("{id}")
   public ExpertDTO update(@PathVariable Long id ,@RequestBody ExpertDTO expertDTO){
        Expert expert = modelMapper.map(expertDTO, Expert.class);
        expert = expertService.edit(id, expert);
        
        return expertDTO;

   }
}
