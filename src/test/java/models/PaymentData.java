package models;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
public class PaymentData {
    private String firstName;

    private String secondName;

    private String zipCode;
}
