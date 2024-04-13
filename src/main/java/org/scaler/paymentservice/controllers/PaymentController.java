package org.scaler.paymentservice.controllers;

import com.razorpay.RazorpayException;
import org.scaler.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String initiatePayment() {
        // initiate payment
        // Make a call to order service to get the order details
        // and then call the payment service to initiate the payment before this line.
            return paymentService.initiatePayment();
    }
}
