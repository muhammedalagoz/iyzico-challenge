package com.iyzico.challenge.iyzico.integration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.iyzico.TestUtils;

@Component
public class RegisterTestUtil extends TestUtils {

	@Autowired
	private Environment env;
	private List<RegisterInputMockBean> registers = new ArrayList<>();
	@Value("${iyzico-challenge.register.inputs.test.count}")
	private Integer testCount;
	private final String REGISTER_TEST_DEFINITIONS_PREFIX = "iyzico-challenge.register.inputs";
	private final String REGISTER_TEST_EXPECTED_PREFIX = "iyzico-challenge.register.inputs.expected";
	private final SimpleDateFormat transactionDateFormatter = new SimpleDateFormat("dd.MM.yyyy");

	@PostConstruct
	private void readTestInputs() {
		try {
			this.logger.info("Total register test inputs definitions count is : " + this.testCount);
			if (this.testCount > 0) {
				// read price definitions

				for (int i = 1; i <= this.testCount; i++) {
					String input[] = this.env.getProperty(this.REGISTER_TEST_DEFINITIONS_PREFIX + "." + i, String.class).split(",");
					String expected = this.env.getProperty(this.REGISTER_TEST_EXPECTED_PREFIX + "." + i, String.class);

					String transactionCode = input[0];
					Date transacitonDate = this.transactionDateFormatter.parse(input[1]);
					String cardNumber = input[2];

					RegisterInputMockBean registerMockBean;
					if (input.length == 4) {
						String discountCode = input[3];
						registerMockBean = new RegisterInputMockBean(transactionCode, transacitonDate, cardNumber, discountCode, expected);
					} else {
						registerMockBean = new RegisterInputMockBean(transactionCode, transacitonDate, cardNumber, expected);
					}

					this.registers.add(registerMockBean);
				}

			}
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
	}

	public List<RegisterInputMockBean> getRegisters() {
		return this.registers;
	}

	public void setRegisters(List<RegisterInputMockBean> registers) {
		this.registers = registers;
	}

	public Integer getTestCount() {
		return this.testCount;
	}

	static class RegisterInputMockBean {
		private String transactionCode;
		private Date transacitonDate;
		private String cardNumber;
		private String discountCode;
		private String expected;

		public RegisterInputMockBean(String transactionCode, Date transacitonDate, String cardNumber, String discountCode, String expected) {
			super();
			this.transactionCode = transactionCode;
			this.transacitonDate = transacitonDate;
			this.cardNumber = cardNumber;
			this.discountCode = discountCode;
			this.expected = expected;
		}

		public RegisterInputMockBean(String transactionCode, Date transacitonDate, String cardNumber, String expected) {
			super();
			this.transactionCode = transactionCode;
			this.transacitonDate = transacitonDate;
			this.cardNumber = cardNumber;
			this.expected = expected;
		}

		public String getTransactionCode() {
			return this.transactionCode;
		}

		public void setTransactionCode(String transactionCode) {
			this.transactionCode = transactionCode;
		}

		public Date getTransacitonDate() {
			return this.transacitonDate;
		}

		public void setTransacitonDate(Date transacitonDate) {
			this.transacitonDate = transacitonDate;
		}

		public String getCardNumber() {
			return this.cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		public String getDiscountCode() {
			return this.discountCode;
		}

		public void setDiscountCode(String discountCode) {
			this.discountCode = discountCode;
		}

		public String getExpected() {
			return this.expected;
		}

		public void setExpected(String expected) {
			this.expected = expected;
		}

		@Override
		public String toString() {
			return "RegisterInputMockBean [transactionCode=" + this.transactionCode + ", transacitonDate=" + this.transacitonDate + ", cardNumber="
					+ this.cardNumber + ", discountCode=" + this.discountCode + ", expected=" + this.expected + "]";
		}

	}
}
