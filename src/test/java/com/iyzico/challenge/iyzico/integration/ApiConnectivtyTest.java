package com.iyzico.challenge.iyzico.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iyzico.TestUtils;
import com.iyzipay.IyzipayResource;
import com.iyzipay.model.ApiTest;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiConnectivtyTest extends TestUtils {

	@Test
	public void should_test_api() {
		IyzipayResource iyzipayResource = ApiTest.retrieve(iyzicoQueryOptions.getQueryOptions());

		logger.info(iyzipayResource);

		assertEquals(Status.SUCCESS.getValue(), iyzipayResource.getStatus());
		assertEquals(Locale.TR.getValue(), iyzipayResource.getLocale());
		assertNotNull(iyzipayResource.getSystemTime());
		assertNull(iyzipayResource.getErrorCode());
		assertNull(iyzipayResource.getErrorMessage());
		assertNull(iyzipayResource.getErrorGroup());
	}

}
