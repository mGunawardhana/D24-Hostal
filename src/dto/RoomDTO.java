package dto;

import lombok.*;
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

public class RoomDTO {
    private String roomID;
    private String roomType;
    private int roomQty;
    private double monthlyRent;
}
