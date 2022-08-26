package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EducationDTO;
import com.example.demo.DTO.ExpertDTO;
import com.example.demo.Model.Education;
import com.example.demo.Model.Expert;
import com.example.demo.exception.Datanotfound;
import com.example.demo.repository.EducationRepo;
import com.example.demo.repository.ExpertRepo;

import lombok.Data;
@Data
@Service
public class EducationService {
  @Autowired
    private final ModelMapper modelMapper;

    private final EducationRepo educationRepo;

  public Education sava(EducationDTO educationDTO){
    Expert expert = new Expert();
    expert.setEx_id(educationDTO.getEx_id());
    Education education = modelMapper.map(educationDTO, Education.class);
    education.setExpert(expert);
    return educationRepo.save(education);
  }

    public List<EducationDTO> getall(){
      List<EducationDTO> list = new ArrayList<>();
      EducationDTO educationDTO = new EducationDTO();
      educationDTO = null;

      for(Education education :educationRepo.findAll()){
          educationDTO = modelMapper.map(education,EducationDTO.class);
          educationDTO.setEx_id(education.getExpert().getEx_id());
          list.add(educationDTO);
      }
      return list;
      
    }
    public EducationDTO getById(Long id){
     Education education = educationRepo.findById(id).orElseThrow(()-> new Datanotfound(id));
     EducationDTO educationDTO = modelMapper.map(education, EducationDTO.class);
     educationDTO.setEx_id(education.getExpert().getEx_id());
     return educationDTO;

    }

    public EducationDTO delete(Long id){
        EducationDTO educationDTO= getById(id);
        Education education= modelMapper.map(educationDTO,Education.class);
        educationRepo.delete(education);
        return educationDTO;
    }
}
