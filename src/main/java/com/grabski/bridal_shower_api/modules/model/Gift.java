package com.grabski.bridal_shower_api.modules.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gift {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GIFT_SEQ")
    @SequenceGenerator(name = "GIFT_SEQ", sequenceName = "GIFT_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_booked")
    private boolean isBooked;
}
