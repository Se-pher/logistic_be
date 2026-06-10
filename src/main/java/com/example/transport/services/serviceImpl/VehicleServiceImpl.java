package com.example.transport.services.serviceImpl;

import com.example.transport.model.Vehicles;
import com.example.transport.repository.VehiclesRepository;
import com.example.transport.services.VehicleService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*d

@Since 6/9/2026
@Author qle20

*/
public class VehicleServiceImpl implements VehicleService {
    @Resource
    private VehiclesRepository vehiclesRepository;

    @Override
    public Void addVehicle(List<Vehicles> vehiclesRequest) {
        List<String> listLicensePlates = vehiclesRequest.stream().map(Vehicles::getLicensePlate).toList();
        List<Vehicles> existingVehicles = vehiclesRepository.findAllByLicensePlate(listLicensePlates);
        for (Vehicles vehicle : vehiclesRequest) {
            if (existingVehicles.stream().anyMatch(existingVehicle -> existingVehicle.getLicensePlate().equals(vehicle.getLicensePlate()))) {
                continue;
            }
            Vehicles newVehicle = new Vehicles();
            newVehicle.setLicensePlate(vehicle.getLicensePlate());
            newVehicle.setCoDriverId(vehicle.getCoDriverId());
            newVehicle.setModel(vehicle.getModel());
            newVehicle.setWeightCapacity(vehicle.getWeightCapacity());
            newVehicle.setStatus(vehicle.getStatus());
            newVehicle.setDriverId(vehicle.getDriverId());
            vehiclesRepository.save(newVehicle);
        }
        return null;
    }

    @Override
    public Page<Vehicles> getListVehicles(Pageable pageable) {
            Page<Vehicles> vehicles = vehiclesRepository.findAll(pageable);
            return vehicles;
    }


}
