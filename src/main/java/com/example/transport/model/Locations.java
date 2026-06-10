package com.example.transport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

/*d

@Since 5/25/2026
@Author qle20

*/
@Data
@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String code;
    private Integer type;
    @Column(name = "current_capacity")
    private Long currentCapacity;
}
