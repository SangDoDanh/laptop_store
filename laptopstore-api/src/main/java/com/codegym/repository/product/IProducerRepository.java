package com.codegym.repository.product;

import com.codegym.dto.ProducerForLapDto;
import com.codegym.model.product.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProducerRepository extends JpaRepository<Producer, Integer> {
    @Query(value = "select id, name, img_url as url\n" +
            "from producer\n" +
            "where is_remove = false and is_laptop = true",
            nativeQuery = true)
    List<ProducerForLapDto> getAllForLap();
}
