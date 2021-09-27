package onlineShop.dao;

import onlineShop.model.Authorities;
import onlineShop.model.Customer;
import onlineShop.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId());
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomerByEmail(String email) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {

            Criteria criteria = session.createCriteria(User.class); // 搜索条件
            //uniqueResult() 返回一个对象,找到一个就结束返回了
            user = (User) criteria.add(Restrictions.eq("emailId", email)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null)
            return user.getCustomer();
        return null;
    }
}
