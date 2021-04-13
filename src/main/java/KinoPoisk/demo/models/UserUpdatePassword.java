package KinoPoisk.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePassword {
    private String email;
    private String full_name;
    private String password;
    private String oldpassword;
}
