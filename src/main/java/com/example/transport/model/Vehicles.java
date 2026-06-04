package com.example.transport.model;

import jakarta.persistence.Column;
import lombok.Data;

/*d

@Since 5/29/2026
@Author qle20

*/
@Data
public class Vehicles {
    private Long id;
    private String model;
    @Column(name = "license_plate")
    private String licensePlate;
    private Boolean status;
    @Column(name = "weight_capacity")
    private Long weightCapacity;
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "co_driver_id")
    private Long coDriverId;
}
