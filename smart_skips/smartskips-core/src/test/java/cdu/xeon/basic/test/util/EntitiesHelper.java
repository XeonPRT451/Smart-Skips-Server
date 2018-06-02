package cdu.xeon.basic.test.util;

import java.util.List;

import org.junit.Assert;


import cdu.xeon.smartskips.model.Driver;


public class EntitiesHelper {
	private static Driver baseDriver = new Driver(1,"admin1","123","admin1","admin1@admin.com","0410454232",1,0,2);
	
	public static Driver getBaseDriver() {
		return baseDriver;
	}
	
	public static void assertUser(Driver expected,Driver actual) {
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getUsername(), actual.getUsername());
		Assert.assertEquals(expected.getNickname(), actual.getNickname());

		Assert.assertEquals(expected.getPhone(), actual.getPhone());
		Assert.assertEquals(expected.getStatus(), actual.getStatus());
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
	}
	
	public static void assertObjects(List<?> expected,List<?> actuals) {
		for(int i=0;i<expected.size();i++) {
			Object eo = expected.get(i);
			Object ao = actuals.get(i);
			Assert.assertEquals(eo, ao);
		}
	}
	
	public static void assertUsers(List<Driver> expected,List<Driver> actuals) {
		for(int i=0;i<expected.size();i++) {
			Driver eu = expected.get(i);
			Driver au = actuals.get(i);
			assertUser(eu, au);
		}
	}
	
	
	
	
	public static void assertUser(Driver expected) {
		assertUser(expected, baseDriver);
	}
}
