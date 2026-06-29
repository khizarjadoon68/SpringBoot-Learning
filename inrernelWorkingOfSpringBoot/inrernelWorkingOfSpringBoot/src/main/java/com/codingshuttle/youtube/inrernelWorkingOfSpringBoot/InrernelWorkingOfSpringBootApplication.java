package com.codingshuttle.youtube.inrernelWorkingOfSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Annotation
@SpringBootApplication
public class InrernelWorkingOfSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {

        SpringApplication.run(InrernelWorkingOfSpringBootApplication.class, args);
    }

    /*
    This is with @Component Annotation
    private RazorpayPaymentService paymentService = new RazorpayPaymentService();
     */

    // With @Component Annotation

    //This is the same thing you write with @Autowired
//    @Autowired
    private PaymenrService paymentService ;

    //Or with this . create Constructor of main class and provide them Bean .
    public InrernelWorkingOfSpringBootApplication(PaymenrService paymentService){
        this.paymentService = paymentService;
    }

        @Override
        public void run(String... args)throws Exception{
            String payment = paymentService.pay();
            System.out.println("Payment Done :"+payment);

        }
	}


