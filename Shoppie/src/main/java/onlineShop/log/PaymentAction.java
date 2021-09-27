package onlineShop.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentAction {

    @Autowired
    private Logger logger;

    public void pay(BigDecimal payValue) {
        logger.log("pay begin, payValue is " + payValue);
        logger.log("pay end");
    }
}



//public class PaymentAction {
//
//    private Logger logger;
//
//    public PaymentAction(Logger logger) {
//        this.logger = logger;
//    }
//
//    public void hello() {
//        logger.log("Hello World");
//    }
//}
