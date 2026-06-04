package com.example.admin.model;

import lombok.Data;

/*d

@Since 5/25/2026
@Author qle20

*/
@Data
public class Locations {
    private Long id;
    private String name;
    private String address;
    private Integer type;
    private Long currentCapacity;
}
