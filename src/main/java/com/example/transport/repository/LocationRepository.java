package com.example.transport.repository;


import com.example.transport.model.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*d

@Since 6/8/2026
@Author qle20

*/
public interface LocationRepository extends JpaRepository<Locations, Long> {

    List<Locations> findAllByCode(List<String> locationCodes);
}
