package org.scaler.paymentservice.services.paymentgateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public String generateLink() {

        try {
            RazorpayClient razorpay = new RazorpayClient("<key>", "<secret-key>");
            JSONObject paymentLinkRequest = new JSONObject();
            // use amount in paise i.e. 1000 paise = 10 INR if decimal amount needs to be accepted.
            // Don't use float or double to represent amount as it may lead to precision issues.
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
            paymentLinkRequest.put("expire_by", 1712944846);
            paymentLinkRequest.put("reference_id", "TS1989");
            paymentLinkRequest.put("description", "Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("name", "Sparsh Raj");
            customer.put("contact", "+918583022292");
            customer.put("email", "sparsh.raj30@gmail.com");
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("reminder_enable", true);

            paymentLinkRequest.put("callback_url", "https://google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();
        }
        catch (RazorpayException e) {
            e.printStackTrace();
        }
        return null;
    }
}
