package com.example.demo.Controler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ExpertDTO;
import com.example.demo.Model.Expert;
import com.example.demo.Service.ExpertService;


@RestController
@RequestMapping("api/expert")
public class ExpertControler {
@Autowired
    private ModelMapper modelMapper;
@Autowired
    private ExpertService expertService;

    @PostMapping("/")
    public ResponseEntity save(@RequestBody ExpertDTO expertDTO){
        Expert expert = modelMapper.map(expertDTO, Expert.class);

        return ResponseEntity.ok(expertService.save(expert));
    }
   
}
