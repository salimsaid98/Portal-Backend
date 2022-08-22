package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Expert;
import com.example.demo.exception.Datanotfound;
import com.example.demo.repository.ExpertRepo;


@Service
public class ExpertService {
    
    private final ExpertRepo expertRepo;

   
@Autowired
    public ExpertService(ExpertRepo expertRepo ){
            this.expertRepo = expertRepo;
    }


    public List<Expert> getExperts(){
        return StreamSupport.stream(expertRepo.findAll().spliterator(),false).
         collect(Collectors.toList());
}

public Expert save(Expert expert){
    return expertRepo.save(expert);
}

public Expert getExpert(Long id){
    return expertRepo.findById(id).orElseThrow(()-> new Datanotfound(id));
}

public Expert delete(Long id){
    Expert expert = getExpert(id);
    expertRepo.delete(expert);
    return expert;
}

public Expert edit(Long id ,Expert expert){
    Expert expert2 = getExpert(id);
     expert2.setF_name(expert.getF_name());
     expert2.setS_name(expert.getS_name());
     expert2.setL_name(expert.getL_name());
     expert2.setAddress(expert.getAddress());
     expert2.setEmail(expert.getEmail());
     expert2.setDob(expert.getDob());
     expert.setPhone(expert.getPhone());
     expert2.setStatus(expert.getStatus());
     expert2.setPassword(expert.getPassword());
        return expertRepo.save(expert2);
}


}
