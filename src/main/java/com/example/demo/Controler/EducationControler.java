package com.example.demo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EducationDTO;
import com.example.demo.Service.EducationService;

import lombok.Data;
@Data
@RestController
@RequestMapping("api/Education")
public class EducationControler {
    @Autowired
    private final EducationService educationService;
    @PostMapping("/")
    public ResponseEntity<EducationDTO> save(@RequestBody EducationDTO educationDTO){
         educationService.save(educationDTO);
        return ResponseEntity.ok().body(educationDTO);
        
    }
    @GetMapping("/")
    public ResponseEntity getall(){
        return ResponseEntity.ok().body(educationService.getall());
    }
    @GetMapping("{id}")
    public ResponseEntity getbyid(@PathVariable Long id){
        return ResponseEntity.ok().body(educationService.getById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok().body(educationService.delete(id));
    }

}
