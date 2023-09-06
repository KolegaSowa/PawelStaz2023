package com.example.shop.entities.address.mapper;

import com.example.shop.dto.AddressDTO;
import com.example.shop.entities.address.model.Address;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T10:50:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address dtoToEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.idAddress( addressDTO.getIdAddress() );
        address.country( addressDTO.getCountry() );
        address.zipCode( addressDTO.getZipCode() );
        address.city( addressDTO.getCity() );
        address.street( addressDTO.getStreet() );
        address.buildingNumber( addressDTO.getBuildingNumber() );
        address.apartmentNumber( addressDTO.getApartmentNumber() );

        return address.build();
    }

    @Override
    public List<Address> dtoToEntity(List<AddressDTO> addressDTOS) {
        if ( addressDTOS == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTOS.size() );
        for ( AddressDTO addressDTO : addressDTOS ) {
            list.add( dtoToEntity( addressDTO ) );
        }

        return list;
    }

    @Override
    public AddressDTO entityToDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setIdAddress( address.getIdAddress() );
        addressDTO.setCountry( address.getCountry() );
        addressDTO.setZipCode( address.getZipCode() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setBuildingNumber( address.getBuildingNumber() );
        addressDTO.setApartmentNumber( address.getApartmentNumber() );
        addressDTO.setMain( address.isMain() );

        return addressDTO;
    }

    @Override
    public List<AddressDTO> entityToDTO(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( entityToDTO( address ) );
        }

        return list;
    }
}
