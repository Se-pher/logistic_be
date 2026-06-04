package com.example.transport.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*d

@Since 5/25/2026
@Author qle20

*/
@Data
@Entity
@Table (name = "trips")
public class Trips {
    @Id
    private Long id;
    @Column (name = "driver_id")
    private Long driverId;
    @Column (name = "miner_id")
    private Long minerId;
    @Column (name = "site_id")
    private Long siteId;
    private Integer status;
    @Column (name = "estimated_weight")
    private Integer estimatedWeight;
    @Column (name = "actual_weight")
    private Integer actualWeight;
    @Column (name = "weightbridge_image_url")
    private String weightBridgeImageUrl;
    @Column (name = "delivery_image_url")
    private String deliveryImageUrl;
    private Integer version;
}
