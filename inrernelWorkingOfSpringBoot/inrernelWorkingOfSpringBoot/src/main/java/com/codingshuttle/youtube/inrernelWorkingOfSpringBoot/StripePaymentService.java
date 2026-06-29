package com.codingshuttle.youtube.inrernelWorkingOfSpringBoot;

import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty ;

/*These All are same
 @Repository
 @Service
 @Controller
 @Compoent
 */
@Component
@ConditionalOnProperty(name = "payment.provider" , havingValue ="stripe" )

public class StripePaymentService implements PaymenrService {

    @Override
    public String pay(){
        String payment = "Stripe Payment";
        System.out.println("Payment From  :"+payment);
        return payment;
    }
}
