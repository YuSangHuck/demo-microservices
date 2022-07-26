package com.demo.customer.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor // for JPA Entity
@AllArgsConstructor // for Builder(NoArgConstructor 사용시 써줘야 함)
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}



