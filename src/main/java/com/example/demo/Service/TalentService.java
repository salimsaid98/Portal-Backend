package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Talent;
import com.example.demo.exception.Datanotfound;
import com.example.demo.repository.TalentRepo;

@Service
public class TalentService {
    
    private final TalentRepo talentRepo;
    @Autowired
    public TalentService(TalentRepo talentRepo){
        this.talentRepo = talentRepo;
    }


    public List<Talent> getTalents(){
        return StreamSupport.stream(talentRepo.findAll().spliterator(),false).
         collect(Collectors.toList());
}

public Talent save(Talent talent){
    return talentRepo.save(talent);
}

public Talent getTalent(Long id){
    return talentRepo.findById(id).orElseThrow(()-> new Datanotfound(id));
}

public Talent delete(Long id){
    Talent talent = getTalent(id);
    talentRepo.delete(talent);
    return talent;
}

public Talent edit(Long id ,Talent talent){
   Talent talent2 = getTalent(id);
   talent2.setSpecialization(talent.getSpecialization());
   talent2.setCertification(talent.getCertification());
   talent2.setBiography(talent.getBiography());
   talent2.setWorkexp(talent.getWorkexp());
    return talentRepo.save(talent2);
}

}
