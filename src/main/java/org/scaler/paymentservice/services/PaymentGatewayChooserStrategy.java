package org.scaler.paymentservice.services;

import org.scaler.paymentservice.services.paymentgateway.PaymentGateway;
import org.scaler.paymentservice.services.paymentgateway.RazorpayPaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;


    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }

    public PaymentGateway choosePaymentGateway() {
        // Some logic to choose the payment gateway
        return razorpayPaymentGateway;
    }
}
