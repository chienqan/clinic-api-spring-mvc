package controller;

import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AddressService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @GetMapping("addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("addresses/{id}")
    public Address getAddress(@PathVariable int id) {
        return addressService.getAddress(id);
    }

    @PostMapping("addresses")
    public int saveAddress(@RequestBody Address address) {
        return addressService.saveAddress(address);
    }

    @PutMapping("addresses")
    public void updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
    }

    @DeleteMapping("addresses/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }
}
