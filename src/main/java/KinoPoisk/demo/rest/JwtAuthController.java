package KinoPoisk.demo.rest;

import KinoPoisk.demo.entities.Users;
import KinoPoisk.demo.jwt.JwtTokenGenerator;
import KinoPoisk.demo.models.JwtRequests;
import KinoPoisk.demo.models.JwtResponse;
import KinoPoisk.demo.services.UserServirce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthController {

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private UserServirce userServirce;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/auth")
    public ResponseEntity<?> auth(@RequestBody JwtRequests request) throws Exception{
        System.out.println("Auth");
        authenticate(request.getEmail(), request.getPassword());
        System.out.println(request);
        final UserDetails userDetails =
                userServirce.loadUserByUsername(request.getEmail());
        final String token = jwtTokenGenerator.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody Users u) throws Exception{
        String password = u.getPassword();
            if(userServirce.createUser(u) !=null ){
                authenticate(u.getEmail(), password);
                final UserDetails userDetails =
                        userServirce.loadUserByUsername(u.getEmail());
                final String token = jwtTokenGenerator.generateToken(userDetails);
                return ResponseEntity.ok(new JwtResponse(token));
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public void authenticate(String email, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }



}
