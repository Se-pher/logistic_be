package com.example.transport.services;


import com.example.transport.model.Vehicles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*d

@Since 6/9/2026
@Author qle20

*/
public interface VehicleService {
    Void addVehicle(List<Vehicles> vehiclesRequest);

    Page<Vehicles> getListVehicles(Pageable pageable);
}
