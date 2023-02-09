package com.codegym.controller.cart;

import com.codegym.dto.CartPayDto;
import com.codegym.dto.ProductCartDto;
import com.codegym.dto.ShipDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.orders.Orders;
import com.codegym.model.orders.OrdersDetail;
import com.codegym.model.product.Product;
import com.codegym.service.cart.ICartService;
import com.codegym.service.cart.IOrderService;
import com.codegym.service.cart.IOrdersDetailService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import com.codegym.service.product.IProductService;
import com.codegym.service.ship.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequestMapping("api/v1/cart")
public class CartRestController {
    @Autowired
    private ICartService cartService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private IOrdersDetailService ordersDetailService;
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IShipService shipService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductCartDto>> getProductByUserId(@PathVariable String id) {
        List<ProductCartDto> productCartDtos = cartService.getProductByUserId(id);
        return new ResponseEntity<>(productCartDtos, HttpStatus.OK);
    }

    @GetMapping("/get-all-ship")
    public ResponseEntity<List<ShipDto>> getAllShip() {
        List<ShipDto> shipDtos = shipService.getAll();
        return new ResponseEntity<>(shipDtos, HttpStatus.OK);
    }
    @PostMapping("/update-quality")
    public ResponseEntity<?> updateQuality(@RequestParam Integer ordersId, Integer quality) {
        OrdersDetail ordersDetail = ordersDetailService.findById(ordersId);
        ordersDetail.setQuality(quality);
        ordersDetailService.save(ordersDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-pay-status")
    public ResponseEntity<?> updatePayStatus(@RequestBody List<CartPayDto> productCartPay) {
        System.out.println(productCartPay);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        for(CartPayDto cartPayDto : productCartPay) {
            OrdersDetail ordersDetail = ordersDetailService.findById(Integer.parseInt(cartPayDto.getOrdersId()));
            ordersDetail.setPayStatus(true);
            Customer customer = ordersDetail.getOrders().getCustomer();
            int point = ordersDetail.getOrders().getCustomer().getDedicationPoint();
            double price = ordersDetail.getQuality() * ordersDetail.getProduct().getProductGroup().getPrice();
            ordersDetail.getOrders().getCustomer().setDedicationPoint(point + (int)price/1000000 * 50);
            if(customer.getDedicationPoint() < 1000) {
                customer.setCustomerType(customerTypes.get(3));
            } else if(customer.getDedicationPoint() < 5000) {
                customer.setCustomerType(customerTypes.get(2));
            } else if(customer.getDedicationPoint() < 15000) {
                customer.setCustomerType(customerTypes.get(1));
            } else if(customer.getDedicationPoint() < 20000) {
                customer.setCustomerType(customerTypes.get(0));
            }
            ordersDetail.setLocationShip(cartPayDto.getLocationShip());
            ordersDetailService.save(ordersDetail);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-remove-status/{idDelete}")
    public ResponseEntity<?> updatePayStatus(@PathVariable Integer idDelete) {
        OrdersDetail ordersDetail = ordersDetailService.findById(idDelete);
        ordersDetail.setRemove(true);
        ordersDetailService.save(ordersDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestParam Integer idAccount, Integer idProduct) {
        Optional<Customer> customerOptional = customerService.findByidAccount(idAccount);
        Customer customer = customerOptional.get();
        Orders orders = new Orders();
        orders.setCustomer(customer);
        orders.setRemove(false);
        orders.setOrderDay(LocalDate.now().toString());
        orderService.save(orders);
        Product product = productService.findByid(idProduct);
        OrdersDetail ordersDetail = new OrdersDetail();
        ordersDetail.setProduct(product);
        ordersDetail.setOrders(orders);
        ordersDetail.setQuality(1);
        ordersDetail.setPayStatus(false);
        ordersDetail.setPayStatus(false);
        ordersDetail.setRemove(false);
        ordersDetailService.save(ordersDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
