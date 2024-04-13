package org.scaler.paymentservice.services.paymentgateway;


import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generateLink() {
        try {
            // Some logic to generate the payment link
            Stripe.apiKey = "";

            PriceCreateParams priceCreateParams = PriceCreateParams.builder()
                    .setCurrency("INR")
                    .setUnitAmount(1000L)
                    .setProductData(
                            PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                    )
                    .build();
            Price price = Price.create(priceCreateParams);
            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            )
                            .setAfterCompletion(
                                    PaymentLinkCreateParams.AfterCompletion.builder()
                                            .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                            .setRedirect(
                                                    PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                            .setUrl("https://www.google.com")
                                                            .build()
                                            )
                                            .build()
                            )
                            .build();

            PaymentLink paymentLink = PaymentLink.create(params);
            return paymentLink.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
