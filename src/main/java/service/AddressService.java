package service;

import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address getAddress(int id) {
        return addressRepository.findOne(id);
    }

    public int saveAddress(Address address) {
        return addressRepository.save(address).getId();
    }

    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(int id) {
        addressRepository.delete(id);
    }
}
