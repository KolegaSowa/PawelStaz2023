package com.example.shop.entities.orders.service;

import com.example.shop.dto.OrdersDTO;
import com.example.shop.entities.client.model.Client;
import com.example.shop.entities.orders.mapper.OrdersMapper;
import com.example.shop.entities.orders.model.Orders;
import com.example.shop.entities.orders.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class OrdersServiceImp implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final AuditReader auditReader;
    private final OrdersMapper ordersMapper;

    @Override
    public List<OrdersDTO> getOrders() {
        return ordersMapper.entityToDTO(ordersRepository.findAll());
    }

    @Override
    public void addOrders(OrdersDTO ordersDTO) {
        ordersRepository.save(ordersMapper.dtoToEntity(ordersDTO));
    }

    @Override
    public void deleteOrder(Long idOrder) {
        boolean exist = ordersRepository.existsById(idOrder);
        if (!exist) {
            throw new IllegalStateException(
                    "Order with id " + idOrder + " does not exist");
        }
        ordersRepository.deleteById(idOrder);
    }

    @Override
    public void updaterOrders(Long idOrder, Client client) {
        if (ordersRepository.findById(idOrder).isPresent()) {
            OrdersDTO ordersDTO = ordersMapper.entityToDTO(ordersRepository.findById(idOrder).get());
            ordersDTO.setClient(client);
            ordersRepository.save(ordersMapper.dtoToEntity(ordersDTO));
        }

    }

    @Override
    public List<OrdersDTO> getAuditOrder(Long idOrder) {
        return auditReader.createQuery().forRevisionsOfEntity(Orders.class, true, true).getResultList();
    }
}
