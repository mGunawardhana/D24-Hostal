package dto;

import lombok.*;

import javax.persistence.Id;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private String UserID;
    private String userName;
    private String password;
}
