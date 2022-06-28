package entity;

import lombok.*;

import javax.persistence.*;
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
public class Reserve implements SuperEntity {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "student_ID", referencedColumnName = "studentID")
    private Student sID;
    @ManyToOne
    @JoinColumn(name = "room_ID", referencedColumnName = "roomID")
    private Room rID;
    private String date;

    @JoinColumn(name = "key_money",referencedColumnName = "keyMoney")
    private double key_money;
}
