package com.example.transport.services;


import com.example.transport.model.Locations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/*d

@Since 6/8/2026
@Author qle20

*/
public interface LocationService {
    void addLocation(List<Locations> locationRequest);

    Page<Locations> getListLocation(Pageable pageable);

}
