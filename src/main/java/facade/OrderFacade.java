package facade;

import entity.Customer;
import entity.ItemType;
import entity.Order;
import entity.OrderLine;

import javax.persistence.EntityManager;

/**
 * Created by adam on 8/25/2017.
 */
public class OrderFacade extends Facade {
    public OrderFacade(EntityManager em) {
        super(em);
    }

    public void saveOrder(Order order, Long customerId) {
        Customer customer = em.find(Customer.class, customerId);
        order.setCustomer(customer);
        saveOrder(order);
    }

    public void saveOrder(Order order) {
        persist(order);
    }

    public Order getOrder(Long id) {
        return em.find(Order.class, id);
    }

    public void saveOrderLine(OrderLine orderLine) {
        persist(orderLine);
    }

    public void saveItemType(ItemType itemType) {
        persist(itemType);
    }

    public double getTotalPrice(Order order) {
        double totalPrice = 0;
        for (OrderLine orderLine : order.getOrderLines()) {
            totalPrice += orderLine.getQuantity() * orderLine.getItemType().getPrice();
        }
        return totalPrice;
    }
}
