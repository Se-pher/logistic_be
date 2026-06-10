package com.example.transport.services.serviceImpl;

import com.example.transport.model.Locations;
import com.example.transport.repository.LocationRepository;
import com.example.transport.services.LocationService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/*d

@Since 6/8/2026
@Author qle20

*/
@Service
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationRepository locationRepository;

    @Override
    public void addLocation(List<Locations> locationRequest) {
        List<String> locationCodes = locationRequest.stream().map(Locations::getCode).toList();
        List<Locations> existingLocations = locationRepository.findAllByCode(locationCodes);
        for (Locations location : locationRequest) {
            if (existingLocations.stream().anyMatch(existingLocation -> existingLocation.getCode().equals(location.getCode()))) {
                continue;
            }
            Locations newLocation = new Locations();
            newLocation.setCode(location.getCode());
            newLocation.setName(location.getName());
            locationRepository.save(newLocation);
        }
    }

    @Override
    public Page<Locations> getListLocation(Pageable pageable) {
        Page<Locations> locations = locationRepository.findAll(pageable);
        return locations;
    }
}
