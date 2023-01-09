package com.codegym.repository.product;

import com.codegym.dto.SizeInchDto;
import com.codegym.model.product.SizeInch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISizeInchRepository extends JpaRepository<SizeInch, Integer> {
    @Query(value = "SELECT s.id as id, s.name as name FROM size_inch s ", nativeQuery = true)
    List<SizeInchDto> getAll();
}
