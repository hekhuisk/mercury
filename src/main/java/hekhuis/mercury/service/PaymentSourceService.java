package hekhuis.mercury.service;

import hekhuis.mercury.entity.PaymentSource;
import hekhuis.mercury.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentSourceService {

    private static Map<Long, PaymentSource> paymentSourceMap = new HashMap<>();

    private static long newPaymentSourceID = 1;

    public PaymentSource savePaymentSource(PaymentSource paymentSource, User user) throws Exception {
        PaymentSource existingPaymentSource = paymentSourceMap.get(paymentSource.getPaymentSourceID());
        if (existingPaymentSource != null) {
            if (existingPaymentSource.getPaymentSourceID() != paymentSource.getPaymentSourceID()) {
                throw new Exception("Invalid payment source ID");
            }
            validateUserCanAccessPaymentSource(existingPaymentSource.getPaymentSourceID(), user);
            paymentSourceMap.replace(existingPaymentSource.getPaymentSourceID(), paymentSource);
        } else {
            paymentSource.setUserID(user.getUserID());
            paymentSource.setPaymentSourceID(newPaymentSourceID++);
            paymentSourceMap.put(paymentSource.getPaymentSourceID(), paymentSource);
        }

        return paymentSource;
    }

    public PaymentSource getPaymentSource(long paymentSourceID, User user) throws Exception {
        validateUserCanAccessPaymentSource(paymentSourceID, user);
        return paymentSourceMap.get(paymentSourceID);
    }

    public void deletePaymentSource(long paymentSourceID, User user) throws Exception {
        validateUserCanAccessPaymentSource(paymentSourceID, user);
    }

    public List<PaymentSource> getAllPaymentSources() {
        return (List<PaymentSource>) paymentSourceMap.values();
    }

    public void validateUserCanAccessPaymentSource(long paymentSourceID, User user) throws Exception {
        PaymentSource paymentSource = paymentSourceMap.get(paymentSourceID);
        if (paymentSource.getUserID() != user.getUserID()) {
            throw new Exception("User does not have access to this payment source");
        }
    }
}
