package com.example.transport.controller.admin;

import com.example.auth.core.ApiResponse;
import com.example.transport.model.Locations;
import com.example.transport.services.LocationService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/*d

@Since 5/29/2026
@Author qle20

*/
@RestController
public class LocationController {
    @Resource
    LocationService locationService;

    @PostMapping
    public ApiResponse<Void> addLocation(@RequestBody List<Locations> locationRequest) {
        locationService.addLocation(locationRequest);
        return new ApiResponse<>(null);
    }

    @GetMapping
    public ApiResponse<Page<Locations>> getLocation(Pageable pageable) {
        return new ApiResponse<>(locationService.getListLocation(pageable));
    }


}
