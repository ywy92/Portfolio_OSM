package com.spring.index;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/Spring/root-context.xml"})
public class RegularExpressionTest {

	public RegularExpressionTest() {
	}

	@Test
	public void testNameRegular() {
		assertTrue(Pattern.matches("^[가-힣]{0,7}", "윤원용"));
		assertFalse(Pattern.matches("^[가-힣]{0,7}", "ㅇ원용"));
		assertFalse(Pattern.matches("^[가-힣]{2,7}", "윤"));
		assertTrue(Pattern.matches("^[가-힣]{2,}", "윤원"));

	}
	
	@Test
	public void testGmailRegular()throws Exception { 
		assertTrue(Pattern.matches("{0}[a-zA-Z]+?[a-zA-Z0-9|_]{0,9}[:@:]+?[a-z]{0,8}[:.:]+?[com|([kr][:.:]+?[co])]+?", "ywyi1992@gmail.com"));
		
		
	}
	
	@Test
	public void testTelRegular() throws Exception {
		assertTrue(Pattern.matches("^[01]{1,2}[0-9]{1}", "010"));
		//assertTrue(Pattern.matches("[01(?=0-9)]{3}[-]{1}", "010-"));
		//assertTrue(Pattern.matches("[01(?=0-9)]{3}[-]{1}[0-9]{3,4}[-]{1}[0-9]{4}","010-2222-2222"));
	}

}
