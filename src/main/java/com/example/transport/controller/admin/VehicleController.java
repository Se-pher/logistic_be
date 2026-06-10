package com.example.transport.controller.admin;

import com.example.auth.core.ApiResponse;
import com.example.transport.model.Vehicles;
import com.example.transport.services.VehicleService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*d

@Since 5/29/2026
@Author qle20

*/
@RestController
public class VehicleController {;
    @Resource
    private VehicleService vehicleService;

    @PostMapping
    public ApiResponse<Void> addVehicle(List<Vehicles> vehiclesRequest) {
        return new ApiResponse<>(vehicleService.addVehicle(vehiclesRequest));
    }

    @GetMapping
    public ApiResponse<List<Vehicles>> getAllVehicles(Pageable pageable) {
        return new ApiResponse<>(vehicleService.getListVehicles(pageable).getContent());
    }

}
