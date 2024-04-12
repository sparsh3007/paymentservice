package org.scaler.paymentservice.services;

public class PaymentService {
    PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy) {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }

    public String initiatePayment() {
        return paymentGatewayChooserStrategy.choosePaymentGateway().generateLink();
    }

}
