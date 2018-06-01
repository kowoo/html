package test;

import org.junit.Test;

import service.MemberService;

public class ServiceTest {
	//테스트를 수행하는 메서드를 가지는 클래스
	MemberService service;
	@Test
	public void testService() {
		service = new MemberService();
		
		boolean result = service.login("gwh", "gwh");
		System.out.println(result);
	}
	
}
