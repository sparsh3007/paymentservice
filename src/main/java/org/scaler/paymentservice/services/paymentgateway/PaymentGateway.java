package org.scaler.paymentservice.services.paymentgateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    public String generateLink() ;
}
