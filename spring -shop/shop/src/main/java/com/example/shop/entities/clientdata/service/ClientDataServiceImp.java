package com.example.shop.entities.clientdata.service;

import com.example.shop.dto.ClientDataDTO;
import com.example.shop.entities.clientdata.mapper.ClientDataMapper;
import com.example.shop.entities.clientdata.model.ClientData;
import com.example.shop.entities.clientdata.repository.ClientDataRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class ClientDataServiceImp implements ClientDataService {

    private final ClientDataRepository clientDataRepository;
    private final AuditReader auditReader;
    private final PasswordEncoder passwordEncoder;
    private final ClientDataMapper clientDataMapper;

    @Override
    public List<ClientDataDTO> getClientData() {
        return clientDataMapper.entityToDTO(clientDataRepository.findAll());
    }

    @Override
    public void addClientData(String clientLogin, String clientPassword, String clientEmail, int phone) {
        ClientDataDTO clientDataDTO = new ClientDataDTO();
        clientDataDTO.setClientLogin(clientLogin);
        clientDataDTO.setClientPassword(passwordEncoder.encode(clientPassword));
        clientDataDTO.setClientEmail(clientEmail);
        clientDataDTO.setPhone(phone);
        clientDataRepository.save(clientDataMapper.dtoToEntity(clientDataDTO));
    }

    @Override
    public void deleteClientData(Long idClientData) {
        boolean exist = clientDataRepository.existsById(idClientData);
        if (!exist) {
            throw new IllegalStateException(
                    "ClientData with id " + idClientData + " does not exist");
        }
        clientDataRepository.deleteById(idClientData);
    }

    @Override
    public void updateClientData(Long idClientData, String clientLogin, String clientPassword, String clientEmail, int phone) {
        if (clientDataRepository.findById(idClientData).isPresent()) {
            ClientDataDTO clientDataDTO = clientDataMapper.entityToDTO(clientDataRepository.findById(idClientData).get());
            clientDataDTO.setClientLogin(clientLogin);
            clientDataDTO.setClientPassword(passwordEncoder.encode(clientPassword));
            clientDataDTO.setClientEmail(clientEmail);
            clientDataDTO.setPhone(phone);
            clientDataRepository.save(clientDataMapper.dtoToEntity(clientDataDTO));
        } else {
            System.out.println("ClientData with id " + idClientData + " does not exist");
        }
    }

    @Override
    public List<ClientDataDTO> getAuditClientData(Long idClientData) {
        return auditReader.createQuery().forRevisionsOfEntity(ClientData.class, true, true).getResultList();
    }
}
