package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemOrdersTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(ItemOrders.class).verify();
	}

}
