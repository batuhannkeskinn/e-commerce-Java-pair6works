package com.etiya.ecommercedemopair6.business.concretes;

import com.etiya.ecommercedemopair6.business.abstracts.AddressService;
import com.etiya.ecommercedemopair6.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair6.business.constants.Message;
import com.etiya.ecommercedemopair6.business.dto.request.concretes.customer.CreateCustomerRequest;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.CreateCustomerResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetAllCustomersResponse;
import com.etiya.ecommercedemopair6.business.dto.response.concretes.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair6.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair6.core.util.result.DataResult;
import com.etiya.ecommercedemopair6.core.util.result.Result;
import com.etiya.ecommercedemopair6.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemopair6.core.util.result.SuccessResult;
import com.etiya.ecommercedemopair6.entities.concretes.Customer;
import com.etiya.ecommercedemopair6.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair6.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private AddressService addressService;
    private AddressRepository addressRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCustomersResponse> >getAll() {

        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomersResponse> responses =
                customers
                .stream()
                .map(customer -> modelMapperService.forResponse().map(customer,GetAllCustomersResponse.class))
                .collect(Collectors.toList());
        return  new SuccessDataResult<>(responses,Message.Customer.getAllCustomers);

    }

    @Override
    public DataResult<GetCustomerResponse> getById(int id) {

        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse response = modelMapperService.forResponse().map(customer,GetCustomerResponse.class);
        return new SuccessDataResult<>(response,Message.Customer.getByCustomerId);

    }

//    public Address getById(int addressId) {
//        public GetAddressResponse getById(int addressId) {
//            Address address = checkIfAddressExistsById(addressId);
//            GetAddressResponse response = modelMapperService.forResponse().map(address, GetAddressResponse.class);
//            return response;
//        }

    @Override
    public DataResult< List<GetAllCustomersResponse>> getAllByFirstName(String name) {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomersResponse> responses = customers.
                stream().map
                        (customer -> modelMapperService.forResponse().map
                                (customer, GetAllCustomersResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(responses,Message.Customer.getAllCustomers);
    }

    @Override
    public DataResult<GetCustomerResponse> customById(int id) {
        Customer customer= customerRepository.customById(id);
        GetCustomerResponse response = modelMapperService.forResponse().map(customer,GetCustomerResponse.class);
        return new SuccessDataResult<>(response,Message.Customer.getByCustomerId);
    }

    @Override
    public Result createCustomer(CreateCustomerRequest createCustomerRequest) {

        checkIfCustomerExistsAddressId(createCustomerRequest.getAddressId());
        checkIfCustomerExistPhoneNumber(createCustomerRequest.getPhoneNumber());
        Customer customer = modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        Customer saveCustomer = customerRepository.save(customer);
        CreateCustomerResponse response = modelMapperService.forResponse().map(saveCustomer, CreateCustomerResponse.class);
        return new SuccessResult(Message.Customer.createCustomer);

    }
        //***********************************ManuelMapper******************************************
//        Address address = addressService.getById(createCustomerRequest.getAddressId());
//        Customer customer = new Customer();
//        customer.setFirstName(createCustomerRequest.getCustomerFirstName());
//        customer.setLastName(createCustomerRequest.getCustomerLastName());
//        customer.setBirthDay(createCustomerRequest.getBirthDay());
//        customer.setEmail(createCustomerRequest.getCustomerEmail());
//        customer.setPhoneNumber(createCustomerRequest.getPhoneNumber());
//        customer.setAddress(address);
//        Customer saveCustomer = customerRepository.save(customer);
//        CreateCustomerResponse response = new CreateCustomerResponse(
//                saveCustomer.getPhoneNumber(),
//                saveCustomer.getFirstName(),
//                saveCustomer.getLastName(),
//                saveCustomer.getEmail(),
//                saveCustomer.getBirthDay(),
//                saveCustomer.getAddress().getAddressId());

        //********************************************************************************/



    public void checkIfCustomerExistsAddressId(int id) {
        boolean isExists = addressRepository.existsById(id);
        if (!isExists) {
            throw new RuntimeException(Message.Customer.CheckIfExistsCustomerId);
        }
    }

    public void checkIfCustomerExistPhoneNumber(String name) {
        boolean isExists = customerRepository.existsByPhoneNumber(name);
        if (!isExists) {
            throw new RuntimeException(Message.Customer.CheckIfExistsCustomerId);
        }
    }
}
