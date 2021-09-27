package onlineShop.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class AppTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("payment.xml");

        PaymentAction paymentAction = (PaymentAction) context.getBean(PaymentAction.class);
//        PaymentAction paymentAction = (PaymentAction) context.getBean("paymentAction"); 这样也可
        paymentAction.pay(new BigDecimal(2));
    }

}
