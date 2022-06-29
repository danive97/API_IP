package com.ufv.dis.final2022.DOV;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertFalse;


@SpringBootTest
class DovApplicationTests {

	@Test
	void IP_NoValida() {
		IP ip = new IP( 0,"28", "Madrid", "28028", "12:00");

		//assertFalse( "IP NO VALIDA", ip.getIp_from() == false);

		assertNotNull(ip.getIp_from(null));
	}
}
