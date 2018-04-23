package fr.univ_smb.isc.m2.domain.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CustomerService {

    private final ArrayList<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer(0, "Ritchie", "Blackmore"));
        customers.add(new Customer(1, "Jon", "Lord"));
        customers.add(new Customer(2, "Ian", "Paice"));
        customers.add(new Customer(3, "Rod", "Evans"));
        customers.add(new Customer(4, "Nick", "Simper"));
    }

    public List<Customer> all() {
        return customers;
    }

    public Customer selectById(int customerId) {
        List<Customer> collect = customers.stream()
                .filter(u -> u.id == customerId)
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }

    public Customer create(String login, String password) {
        Customer customer = new Customer(customers.size() , login, password);
        customers.add(customer);
        return customer;
    }
}
