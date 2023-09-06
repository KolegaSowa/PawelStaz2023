package com.example.shop.entities.historyofchange.service;

import com.example.shop.dto.HistoryOfChangeDTO;
import com.example.shop.entities.employee.model.Employee;
import com.example.shop.entities.historyofchange.mapper.HistoryOfChangeMapper;
import com.example.shop.entities.historyofchange.model.HistoryOfChange;
import com.example.shop.entities.historyofchange.repository.HistoryOfChangeRepository;
import com.example.shop.entities.product.model.Product;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@AllArgsConstructor
@Service
class HistoryOfChangeServiceImp implements HistoryOfChangeService {

    private final HistoryOfChangeRepository historyOfChangeRepository;
    private final AuditReader auditReader;
    private final HistoryOfChangeMapper historyOfChangeMapper;

    @Override
    public List<HistoryOfChangeDTO> getHistoryOfChange() {
        return historyOfChangeMapper.entityToDTO(historyOfChangeRepository.findAll());
    }

    @Override
    public void addHistoryOfChange(HistoryOfChangeDTO historyOfChangeDTO) {
        historyOfChangeRepository.save(historyOfChangeMapper.dtoToEntity(historyOfChangeDTO));
    }

    @Override
    public void deleteHistoryOfChange(Long idHistoryOfChange) {
        boolean exist = historyOfChangeRepository.existsById(idHistoryOfChange);
        if (!exist) {
            throw new IllegalStateException(
                    "HistoryOfChange with id " + idHistoryOfChange + " does not exist");
        }
        historyOfChangeRepository.deleteById(idHistoryOfChange);
    }

    @Override
    public void updateHistoryOfChange(Long idHistoryOfChange, Product product, Employee employee, float oldPrice, float newPrice, SimpleDateFormat dateOfChange) {
        if (historyOfChangeRepository.findById(idHistoryOfChange).isPresent()) {
            HistoryOfChangeDTO historyOfChange = historyOfChangeMapper.entityToDTO(historyOfChangeRepository.findById(idHistoryOfChange).get());
            historyOfChange.setProduct(product);
            historyOfChange.setEmployee(employee);
            historyOfChange.setOldPrice(oldPrice);
            historyOfChange.setNewPrice(newPrice);
            historyOfChange.setDateOfChange(dateOfChange);
            historyOfChangeRepository.save(historyOfChangeMapper.dtoToEntity(historyOfChange));
        } else {
            System.out.println("HistoryOfChange with id " + idHistoryOfChange + " does not exist");
        }

    }

    @Override
    public List<HistoryOfChangeDTO> getAuditHistoryOfChange(Long idOfHistoryOfChange) {
        return auditReader.createQuery().forRevisionsOfEntity(HistoryOfChange.class, true, true).getResultList();
    }
}
