package KinoPoisk.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequests implements Serializable {

    private static final long serialVersionUID = 123456789L;
    private String email;
    private String password;


}
