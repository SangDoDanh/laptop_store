package com.codegym.repository.product;

import com.codegym.dto.*;
import com.codegym.model.product.ProductGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = "select p.id, p.name, p.price, p.size, p.url_img as urlImgs, p.weight, c.name as categoryName, pc.name as producerName, si.name as inch, w.warranty_month as warrantyMonth\n" +
            "from product_group p\n" +
            "    join category c on c.id = p.category_id\n" +
            "    join producer pc on p.producer_id = pc.id\n" +
            "    join size_inch si on p.size_inch_id = si.id\n" +
            "    join warranty w on p.warranty_id = w.id\n" +
            "where p.is_remove = false " +
            "    and p.name like %:#{#searchDto.nameSearch}% " +
            "and si.id in :#{#searchDto.inchSearch} " +
            "and (p.price BETWEEN :#{#searchDto.priceSearch.get(0)} and :#{#searchDto.priceSearch.get(1)}) " +
            "and pc.id in :#{#searchDto.producer} "
            , nativeQuery = true)
    List<ProductGroupDto> search(@Param("searchDto") SearchDto searchDto);

    @Query(value = "select product_group.id, \n" +
            "       product_group.name,\n" +
            "        product_group.price,\n" +
            "        size_inch.name as `size`,\n " +
            "        product_group.url_img as urlImgs,\n" +
            "        product_group.weight, category.name as categoryName,\n" +
            "        producer.name as producerName,\n" +
            "        size_inch.name as inch,\n" +
            "        warranty.warranty_month as warrantyMonth\n" +
            "from `product_group` join category on product_group.category_id = category.id\n " +
            "    join producer on product_group.producer_id = producer.id\n" +
            "    join size_inch on product_group.size_inch_id = size_inch.id\n" +
            "    join warranty on product_group.warranty_id = warranty.id " +
            "where product_group.is_remove = false " +
            "    and product_group.name like %:#{#searchDto.nameSearch}% " +
            "and size_inch.id in :#{#searchDto.inchSearch} " +
            "and (product_group.price BETWEEN :#{#searchDto.priceSearch.get(0)} and :#{#searchDto.priceSearch.get(1)}) " +
            "and producer.id in :#{#searchDto.producer} "
            , nativeQuery = true)
    Page<ProductGroupDto> searchAndPage(@Param("searchDto") SearchDto searchDto, Pageable pageable);

    @Query(value = "select product_group.id, product_group.name " +
            "from `product_group` join `category` on product_group.category_id = category.id"
            , nativeQuery = true)
    Page<Demopage> demopage(Pageable pageable);
    @Query(value = "SELECT p.id," +
            " pg.name, " +
            " od.id as ordersId, " +
            "pg.url_img as urlImgs, " +
            "pg.price, p.color, " +
            "d.name as discountName, " +
            "d.discount_val as discountVal, " +
            "d.end_day as endDay, " +
            "od.quality, " +
            "lr.ram_val as ram, " +
            "l.name as cpu, lm.memory_val as memory, " +
            "lmt.name as memtype, " +
            "lmssd.memory_val as ssdVal, " +
            "pg.weight as weight, " +
            "o.order_day as ordersDay ," +
            "pg.id as productGroupId, " +
            "od.location_ship as locationShip \n" +
            "FROM account a join customer c on a.id = c.account_id\n" +
            "    join orders o on c.id = o.customer_id\n" +
            "    join orders_detail od on o.id = od.orders_id\n" +
            "    join product p on od.product_id = p.id\n" +
            "    join product_group pg on p.product_group_id = pg.id\n" +
            "    join discount d on p.discount_id = d.id\n " +
            "    join lap_ram lr on p.lap_ram_id = lr.id\n " +
            "    join lapcpu l on p.lapcpu_id = l.id\n" +
            "    join lap_memory lm on p.lap_memoryhd_id = lm.id " +
            "    join lap_memory_type lmt on lm.lap_memory_type_id = lmt.id " +
            "    join lap_memory lmssd on p.lap_memoryssd_id = lmssd.id " +
            "where a.id = :id and od.pay_status = false and od.is_remove = false ", nativeQuery = true)
    List<ProductCartDto> getProductByUserId(@Param("id") String id);
    @Query(value = "select p.id,\n" +
            "       product_group.name,\n" +
            "       l2.name as cpu,\n" +
            "       l3.name as gpu,\n" +
            "       lm.memory_val as hhd,\n" +
            "       l.memory_val as ssd,\n" +
            "       p.color,\n" +
            "       dt.name as display,\n" +
            "       d.discount_val as discountVal,\n" +
            "       d.name as discountName,\n" +
            "       sr.name as ratio,\n" +
            "       r.val as resolVal,\n" +
            "       r.name as resolName,\n" +
            "       l2.quality_core as qualityCoreCpu,\n" +
            "       l2.quality_thread as qualityThreadCpu,\n" +
            "       l3.quality_core as qualityCoreGpu,\n" +
            "       l3.quality_thread as qualityThreadGpu,\n" +
            "       lr.ram_val as ram\n" +
            "from product_group join product p on product_group.id = p.product_group_id\n" +
            "                   join lap_memory lm on p.lap_memoryhd_id = lm.id\n" +
            "                   join lap_memory l on l.id = p.lap_memoryssd_id\n" +
            "                   join discount d on p.discount_id = d.id\n" +
            "                   join display_tech dt on p.display_tech_id = dt.id\n" +
            "                   join screen_ratio sr on p.screen_ratio_id = sr.id\n" +
            "                   join lapcpu l2 on p.lapcpu_id = l2.id\n" +
            "                   join lapgpu l3 on p.lapgpu_id = l3.id\n" +
            "                   join lap_ram lr on p.lap_ram_id = lr.id\n" +
            "                   join resolution r on p.resolution_id = r.id\n" +
            "where product_group.id = :id and p.is_remove = false", nativeQuery = true)
    List<ProductDetailListDto> getAllProductDetailByProductgroupId(@Param("id") String id);

    @Query(value = "SELECT p.id," +
            " pg.name, " +
            " od.id as ordersId, " +
            "pg.url_img as urlImgs, " +
            "pg.price, p.color, " +
            "d.name as discountName, " +
            "d.discount_val as discountVal, " +
            "d.end_day as endDay, " +
            "od.quality, " +
            "lr.ram_val as ram, " +
            "l.name as cpu, lm.memory_val as memory, " +
            "lmt.name as memtype, " +
            "lmssd.memory_val as ssdVal, " +
            "pg.weight as weight, " +
            "o.order_day as ordersDay, " +
            "pg.id as productGroupId, " +
            "od.location_ship as locationShip \n" +
            "FROM account a join customer c on a.id = c.account_id\n" +
            "    join orders o on c.id = o.customer_id\n" +
            "    join orders_detail od on o.id = od.orders_id\n" +
            "    join product p on od.product_id = p.id\n" +
            "    join product_group pg on p.product_group_id = pg.id\n" +
            "    join discount d on p.discount_id = d.id\n " +
            "    join lap_ram lr on p.lap_ram_id = lr.id\n " +
            "    join lapcpu l on p.lapcpu_id = l.id\n" +
            "    join lap_memory lm on p.lap_memoryhd_id = lm.id " +
            "    join lap_memory_type lmt on lm.lap_memory_type_id = lmt.id " +
            "    join lap_memory lmssd on p.lap_memoryssd_id = lmssd.id " +
            "where a.id = :id and od.pay_status = true and od.is_remove = false " +
            "order by o.order_day DESC ", nativeQuery = true)
    List<ProductCartDto> getProductByUserIdPay(Integer id);
}
