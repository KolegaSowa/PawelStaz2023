package com.example.shop.entities.orders.controller;

import com.example.shop.dto.OrdersDTO;
import com.example.shop.entities.client.model.Client;
import com.example.shop.entities.orders.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/orders")
class OrdersController {

    private final OrdersService ordersService;

    @GetMapping
    public List<OrdersDTO> getOrders() {
        return ordersService.getOrders();
    }

    @PostMapping
    public void addOrders(@RequestBody OrdersDTO ordersDTO) {
        ordersService.addOrders(ordersDTO);
    }

    @DeleteMapping(path = "{id_order}")
    public void deleteOrder(@PathVariable("id_order") Long idOrder) {
        ordersService.deleteOrder(idOrder);
    }

    @PutMapping("/update/{idOrder}")
    public void updateOrder(@PathVariable long iOrder, @RequestBody Client client) {
        ordersService.updaterOrders(iOrder, client);
    }

    @GetMapping("audited/{idOrder}")
    List<OrdersDTO> getAuditOrder(@PathVariable long idOrder) {
        return ordersService.getAuditOrder(idOrder);
    }

}