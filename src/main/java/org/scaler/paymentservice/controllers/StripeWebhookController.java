package org.scaler.paymentservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripeWebhook")
public class StripeWebhookController {
    public void webhook() {
        // Some logic to handle the webhook
        System.out.println("Webhook received");
    }
}
