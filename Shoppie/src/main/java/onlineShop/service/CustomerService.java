package onlineShop.service;

import onlineShop.dao.CustomerDao;
import onlineShop.model.Cart;
import onlineShop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//功能等价于respo
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        // 验证是一个合法的用户
        customer.getUser().setEnabled(true);

        Cart cart = new Cart();
        customer.setCart(cart);

        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        return customerDao.getCustomerByEmail(userName);
    }
}
