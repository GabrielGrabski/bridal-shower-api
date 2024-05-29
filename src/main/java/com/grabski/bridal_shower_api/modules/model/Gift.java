package com.grabski.bridal_shower_api.modules.model;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Getter
@Setter
@Builder
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

    @Column(name = "image_name")
    private String imageName;
}
