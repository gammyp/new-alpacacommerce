package cf.alpaca202.Shopping.services;

import cf.alpaca202.Shopping.models.Address;
import cf.alpaca202.Shopping.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
}
