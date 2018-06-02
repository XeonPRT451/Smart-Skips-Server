package cdu.xeon.smartskips.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import org.owasp.esapi.ESAPI; 

public class OWASPTest {

	@Test
	public void test() {
		String safe = ESAPI.encoder().encodeForHTML("<script>alert('xss')</script>");  
        
        System.out.println(safe);  
	}

}
