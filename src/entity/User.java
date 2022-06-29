package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
/*
 * Developed by - mGunawardhana
 * Contact email - mrgunawardhana27368@gmail.com
 * what's app - 071 - 9043372
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

@Entity
public class User implements SuperEntity{
    @Id
    private String UserID;
    private String userName;
    private String password;
}
