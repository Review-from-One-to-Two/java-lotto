package lotto.domain.paymentinfo;

import lotto.exception.PaymentOutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {
    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment(1_000);
    }

    @Test
    void 생성자_확인() {
        assertThat(payment).isEqualTo(new Payment(1_000));
    }

    @Test
    void 생성자_확인_0을_입력했을_때() {
        assertThatThrownBy(() -> new Payment(0)).isInstanceOf(PaymentOutOfBoundsException.class);
    }

    @Test
    void calculateCountOfLotto() {
        assertThat(payment.calculateCountOfLotto()).isEqualTo(1);
    }

    @Test
    void calculateEarningsRate() {
        assertThat(payment.calculateEarningsRate(10_000)).isEqualTo(10.0);
    }
}