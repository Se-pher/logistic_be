package com.example.transport.repository;


import com.example.transport.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*d

@Since 6/9/2026
@Author qle20

*/
public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
    List<Vehicles> findAllByLicensePlate(List<String> listLicensePlates);
}
