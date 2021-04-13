package KinoPoisk.demo.rest;

import KinoPoisk.demo.entities.Users;
import KinoPoisk.demo.models.UserDTO;
import KinoPoisk.demo.models.UserUpdatePassword;
import KinoPoisk.demo.services.UserServirce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class MainController {
    @Autowired
    private UserServirce userServirce;


    @GetMapping(value = "/profile")
    public ResponseEntity<?> profilePage(){
        Users user = getUser();
        return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getFull_name(), user.getRoles()), HttpStatus.OK);
    }

    @PostMapping(value = "/updatefullname")
    public ResponseEntity<?> updatefullname(@RequestBody Users user){
        Users user1 = userServirce.getUserByEmail(user.getEmail());
        if(user1 !=null){
            user1.setFull_name(user.getFull_name());
            user = userServirce.saveUser(user1);
        }
        return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getFull_name(), user.getRoles()), HttpStatus.OK);
    }

    @PostMapping(value = "/updatepassword")
    public ResponseEntity<?> updatepassword(@RequestBody UserUpdatePassword userUpdatePassword) {
        Users user = getUser();
        user = userServirce.updateUserpassword(user, userUpdatePassword.getOldpassword(), userUpdatePassword.getPassword());
        if (user != null) {
            return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getFull_name(), user.getRoles()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private Users getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            Users user = (Users) authentication.getPrincipal();
            return user;
        }
        return null;
    }

}
