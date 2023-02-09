package com.codegym.repository.ship;

import com.codegym.dto.ShipDto;
import com.codegym.model.ship.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IShipRepository extends JpaRepository<Ship, Integer> {
    @Query(value = "select s.id, s.name, s.fare_size as fareSize, s.fare_weight as fareWeight, s.url_image as urlImage\n" +
            "from ship as s\n" +
            "where is_remove = false"
            , nativeQuery = true)
    List<ShipDto> getAll();
}
