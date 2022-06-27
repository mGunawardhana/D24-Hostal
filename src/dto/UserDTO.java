package dto;

import lombok.*;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private String UserID;
    private String userName;
    private String password;
}
