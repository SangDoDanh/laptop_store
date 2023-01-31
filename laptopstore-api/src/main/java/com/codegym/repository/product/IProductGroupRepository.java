package com.codegym.repository.product;

import com.codegym.dto.ProductDto;
import com.codegym.dto.ProductGroupDetailDto;
import com.codegym.dto.ProductGroupDto;
import com.codegym.model.product.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductGroupRepository extends JpaRepository<ProductGroup, Integer> {
    @Query(value = "select p.id, p.name, p.price, p.size, p.url_img as urlImgs, p.weight, c.name as categoryName, pc.name as producerName, si.name as inch, w.warranty_month as warrantyMonth\n" +
            "from product_group p\n" +
            "    join category c on c.id = p.category_id\n" +
            "    join producer pc on p.producer_id = pc.id\n" +
            "    join size_inch si on p.size_inch_id = si.id\n" +
            "    join warranty w on p.warranty_id = w.id\n" +
            "where p.is_remove = false", nativeQuery = true)
    List<ProductGroupDto> getAll();

    @Query(value = "select lc.name as cpuName, lr.name as ramName, lg.name as gpuName, lr.ram_val as ram \n" +
            "from product_group pg  join product p on pg.id = p.product_group_id\n" +
            "    join lapcpu lc on p.lapcpu_id = lc.id\n" +
            "    join lapgpu lg on p.lapgpu_id = lg.id\n" +
            "    join lap_ram lr on p.lap_ram_id = lr.id\n" +
            "where p.id = :id \n " +
            "limit 1", nativeQuery = true)
    ProductGroupDetailDto getAllDetail(@Param("id") Integer id);

    @Query(value = "select p.id, p.name, p.price, p.size, p.url_img as urlImgs, p.weight, c.name as categoryName, pc.name as producerName, si.name as inch, w.warranty_month as warrantyMonth\n" +
            "from product_group p\n" +
            "    join category c on c.id = p.category_id\n" +
            "    join producer pc on p.producer_id = pc.id\n" +
            "    join size_inch si on p.size_inch_id = si.id\n" +
            "    join warranty w on p.warranty_id = w.id\n" +
            "where p.is_remove = false and p.id = :id", nativeQuery = true)
    Optional<ProductDto> getProductById(@Param("id") Integer id);
}
