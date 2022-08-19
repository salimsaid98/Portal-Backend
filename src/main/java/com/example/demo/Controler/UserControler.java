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

import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;


@RestController

@RequestMapping("api/user")
public class UserControler {
    @Autowired
    private ModelMapper modelMapper;
@Autowired
private UserService userService;

@PostMapping("/")
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);

        return ResponseEntity.ok(userService.save(user));
    }
    @GetMapping("/")
    public ResponseEntity getall(){
        List<UserDTO> list = new ArrayList<>();
        // User user = new User();
        UserDTO userDTO = new UserDTO();
        userDTO = null;
        for(User user2:userService.getUsers()){
            userDTO = modelMapper.map(user2, UserDTO.class);
            list.add(userDTO);

        }
        return ResponseEntity.ok(list);
    }
@GetMapping("{id}")
public ResponseEntity<UserDTO> getbyid(@PathVariable Long id){

    User user = userService.getUser(id);
    UserDTO userDTO = 
    modelMapper.map(user, UserDTO.class);

    return ResponseEntity.ok().body(userDTO);
    

}
@DeleteMapping("{id}")
public ResponseEntity<UserDTO>delete(@PathVariable Long id){
        User user = userService.delete(id);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(userDTO);
}
@PutMapping("{id}")
public ResponseEntity<UserDTO> update(@PathVariable Long id ,@RequestBody UserDTO userDTO){
    //convert DTO to entity
    User userRequest = modelMapper.map(userDTO, User.class);
    
    User user = userService.edit(id, userRequest);

    //convert entity to DTO

    UserDTO userRespond = modelMapper.map(user, UserDTO.class);

    return ResponseEntity.ok().body(userRespond);




}
// public ResponseEntity<User> update(@PathVariable Long id ,@RequestBody User user){
//     User user2 = userService.edit(id, user);
//     return ResponseEntity.ok().body(user2);
// }

}
