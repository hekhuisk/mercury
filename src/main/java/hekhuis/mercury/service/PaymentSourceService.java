package hekhuis.mercury.service;

import hekhuis.mercury.entity.PaymentSource;
import hekhuis.mercury.entity.User;
import hekhuis.mercury.repository.PaymentSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentSourceService {

    @Autowired
    private PaymentSourceRepository paymentSourceRepository;

    public PaymentSource updatePaymentSource(long paymentSourceID, PaymentSource paymentSource, User user) throws Exception {
        getPaymentSource(paymentSourceID, user);
        paymentSource.setUserID(paymentSourceID);
        return paymentSourceRepository.save(paymentSource);
    }

    public PaymentSource createPaymentSource(PaymentSource paymentSource, User user) {
        return paymentSourceRepository.save(paymentSource);
    }

    public PaymentSource getPaymentSource(long paymentSourceID, User user) throws Exception {
        PaymentSource paymentSource = paymentSourceRepository.findById(paymentSourceID)
                .orElseThrow(() -> new Exception("Payment Source not found for this id :: " + paymentSourceID));
        return paymentSource;
    }

    public void deletePaymentSource(long paymentSourceID, User user) throws Exception {
        PaymentSource paymentSource = getPaymentSource(paymentSourceID, user);
        paymentSourceRepository.delete(paymentSource);
    }

    public List<PaymentSource> getAllPaymentSourcesForUser(long userID) {
        return new ArrayList<>(paymentSourceRepository.findAllByUserID(userID));
    }
}
