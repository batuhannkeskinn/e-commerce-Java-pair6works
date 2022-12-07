package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    private AddressService addressService;
    private AddressRepository addressRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getAllByFirstName(String name) {

        return customerRepository.findAllCustomersByFirstName(name);
    }

    @Override
    public Customer customById(int id) {
        return customerRepository.customById(id);
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {
        checkIfCustomerExistsAddressId(createCustomerRequest.getAddressId());
        Address address = addressService.getById(createCustomerRequest.getAddressId());
        Customer customer = new Customer();
        customer.setFirstName(createCustomerRequest.getCustomerFirstName());
        customer.setLastName(createCustomerRequest.getCustomerLastName());
        customer.setBirthDay(createCustomerRequest.getBirthDay());
        customer.setEmail(createCustomerRequest.getCustomerEmail());
        customer.setPhoneNumber(createCustomerRequest.getPhoneNumber());

        customer.setAddress(address);
        Customer saveCustomer = customerRepository.save(customer);



        CreateCustomerResponse response = new CreateCustomerResponse(
                saveCustomer.getPhoneNumber(),
                saveCustomer.getFirstName(),
                saveCustomer.getLastName(),
                saveCustomer.getEmail(),
                saveCustomer.getBirthDay(),
                saveCustomer.getAddress().getAddressId());

        return response;
    }

    public void checkIfCustomerExistsAddressId(int id){
        boolean isExists = addressRepository.existsById(id);
        if(!isExists){
            throw new RuntimeException("Kişinin sistemde kayıtlı bir adresi yok");
        }
    }
}
