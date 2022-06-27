package dto;

import lombok.*;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class UserDTO {
    @Id
    private int UserID;

    private String userName;
    private String password;
}
