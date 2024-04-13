package org.scaler.paymentservice.services;

import org.scaler.paymentservice.services.paymentgateway.PaymentGateway;
import org.scaler.paymentservice.services.paymentgateway.RazorpayPaymentGateway;
import org.scaler.paymentservice.services.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway,
                                         StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway choosePaymentGateway() {
        // Some logic to choose the payment gateway
        return stripePaymentGateway;
    }
}
