package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EducationDTO;
import com.example.demo.DTO.EducationResponseDTO;
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
   @Autowired
    private final EducationRepo educationRepo;

  public Education save(EducationDTO educationDTO){
    System.out.println(educationDTO);
    Education education = modelMapper.map(educationDTO, Education.class);
    education.setExpert(new Expert(educationDTO.getEx_id()));
    Education education2 = educationRepo.save(education);
    return  education2;
  }

    public List<EducationResponseDTO> getall(){
      List<EducationResponseDTO> list = new ArrayList<>();
      EducationResponseDTO educationDTO = new EducationResponseDTO();
      educationDTO = null;

      for(Education education :educationRepo.findAll()){
          educationDTO = modelMapper.map(education,EducationResponseDTO.class);
          // educationDTO.setEx_id(education.getExpert().getEx_id());
          educationDTO.setF_name(education.getExpert().getF_name());
          educationDTO.setS_name(education.getExpert().getS_name());
          educationDTO.setL_name(education.getExpert().getL_name());
          educationDTO.setGander(education.getExpert().getGander());
          educationDTO.setEmail(education.getExpert().getEmail());
          educationDTO.setAddress(education.getExpert().getAddress());
          educationDTO.setStatus(education.getExpert().getStatus());
          educationDTO.setPhone(education.getExpert().getPhone());
          educationDTO.setDob(education.getExpert().getDob());
          
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
