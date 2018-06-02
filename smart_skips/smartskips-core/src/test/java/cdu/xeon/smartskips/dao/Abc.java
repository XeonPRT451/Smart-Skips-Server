package cdu.xeon.smartskips.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class Abc {

	@Test
	public void test() {
		java.util.Random r= new java.util.Random();
		
		System.out.println(r);
			long l = r.nextInt();
			System.out.println(l);
			long m =r.nextInt();
			System.out.println(m);
			
	   System.out.println(l+ ( m<<32 ));
		
		
	}

}
