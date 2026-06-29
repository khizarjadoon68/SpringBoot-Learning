package com.codingshuttle.youtube.inrernelWorkingOfSpringBoot;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider" , havingValue ="razor" )
public class RazorpayPaymentService implements PaymenrService {

    @Override
    public String pay(){
        String payment = "Razor Payment";
        System.out.println("Payment From  :"+payment);
        return payment;
    }
}
