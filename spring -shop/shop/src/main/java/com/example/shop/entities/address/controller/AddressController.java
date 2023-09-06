package com.example.shop.entities.address.controller;

import com.example.shop.dto.AddressDTO;
import com.example.shop.entities.address.service.AddressService;
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
@RequestMapping(path = "/address")
class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressDTO> getAddress() {
        return addressService.getAddress();
    }

    @PostMapping("/add")
    public void addAddress(@RequestBody AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
    }

    @DeleteMapping(path = "{id_address}")
    public void deleteAddress(@PathVariable("id_address") Long idAddress) {
        addressService.deleteAddress(idAddress);
    }


    @PutMapping("/update/{idAddress}")
    public void updateAddress(@PathVariable long idAddress, @RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(idAddress, addressDTO.getCountry(), addressDTO.getZipCode(), addressDTO.getCity(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), addressDTO.getApartmentNumber(), addressDTO.isMain());
    }


    @GetMapping("/audited/{idAddress}")
    List<AddressDTO> getAuditAddress(@PathVariable long idAddress) {
        return addressService.getAuditAddress(idAddress);
    }
}
