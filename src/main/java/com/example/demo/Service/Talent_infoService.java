// package com.example.demo.Service;

// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.StreamSupport;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.Model.Talent_info;
// import com.example.demo.exception.Datanotfound;
// import com.example.demo.repository.TalentRepo;
// import com.example.demo.repository.Talent_infoRepo;

// @Service
// public class Talent_infoService {
//     private final Talent_infoRepo talent_infoRepo;
// @Autowired
//     public Talent_infoService(Talent_infoRepo talent_infoRepo){
//         this.talent_infoRepo = talent_infoRepo;

//     }


//  public List<Talent_info> getTalent_infos(){
//         return StreamSupport.stream(talent_infoRepo.findAll().spliterator(),false).
//          collect(Collectors.toList());
// }


// public Talent_info getTalent_info(Long id){
//     return talent_infoRepo.findById(id).orElseThrow(()-> new Datanotfound(id));
// }

// public Talent_info delete(Long id){
//     Talent_info talent_info = getTalent_info(id);
//     talent_infoRepo.delete(talent_info);
//     return talent_info;
// }




// }
