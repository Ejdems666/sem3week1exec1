package facade;

import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by adam on 22/08/2017.
 */
public class CustomerFacade extends Facade{
    public CustomerFacade(EntityManager em) {
        super(em);
    }

    public Customer getCustomer(Long id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT u FROM Customer u");
        return query.getResultList();
    }

    public void saveCustomer(Customer customer) {
        persist(customer);
    }
}

