package com.example.shop.entities.address.service;

import com.example.shop.dto.AddressDTO;
import com.example.shop.entities.address.mapper.AddressMapper;
import com.example.shop.entities.address.model.Address;
import com.example.shop.entities.address.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;
    private final AuditReader auditReader;
    private final AddressMapper addressMapper;

    @Override
    public List<AddressDTO> getAddress() {
        return addressMapper.entityToDTO(addressRepository.findAll());
    }

    @Override
    public void addAddress(AddressDTO addressDTO) {
        addressRepository.save(addressMapper.dtoToEntity(addressDTO));
    }

    @Override
    public void deleteAddress(Long idAddress) {
        boolean exist = addressRepository.existsById(idAddress);
        if (!exist) {
            throw new IllegalStateException(
                    "Address with id" + idAddress + "does not exist");
        }
        addressRepository.deleteById(idAddress);
    }

    @Override
    public void updateAddress(
            Long idAddress, String country, String zipCode, String city, String street, String buildingNumber, String apartmentNumber, boolean isMain) {
        if (addressRepository.findById(idAddress).isPresent()) {
            AddressDTO addressDTO = addressMapper.entityToDTO(addressRepository.findById(idAddress).get());
            addressDTO.setCountry(country);
            addressDTO.setZipCode(zipCode);
            addressDTO.setCity(city);
            addressDTO.setStreet(street);
            addressDTO.setBuildingNumber(buildingNumber);
            addressDTO.setApartmentNumber(apartmentNumber);
            addressDTO.setMain(isMain);
            addressRepository.save(addressMapper.dtoToEntity(addressDTO));
        } else {
            System.out.println("Address with id " + idAddress + " does not exist");
        }
    }


    @Override
    public List<AddressDTO> getAuditAddress(Long idAddress) {
        return auditReader.createQuery().forRevisionsOfEntity(Address.class, true, true).getResultList();
    }
}
