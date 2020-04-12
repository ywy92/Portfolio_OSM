package com.spring.index.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.common.model.DuplicateDTO;
import com.spring.common.model.SearchDTO;
import com.spring.member.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberTest {
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Test
	public void testInsert() {
		MemberDTO dto = new MemberDTO();
		dto.setM_id("admin");
		dto.setM_password("1234#");
		dto.setM_nickname("admin");
		dto.setM_name("윤원용");
		dto.setM_birth("1992-11-07");
		dto.setM_age(29);
		dto.setM_gender('0');
		dto.setM_zipcode("777777");
		dto.setM_address1("testAddress1");
		dto.setM_address2("testAddress2");
		dto.setM_phone("010-2571-3495");
		dto.setM_email("ywyi1992@gmail.com");
		assertTrue(sqlSession.insert("com.spring.member.insert", dto) == 1);
	}
	@Test
	public void testUpdate() {
		MemberDTO dto = new MemberDTO();
		dto.setM_id("admin");
		dto.setM_password("1234");
		assertTrue(sqlSession.update("com.spring.member.update", dto) == 1);
		dto = new MemberDTO();
		dto.setM_id("admin");
		dto.setM_grant('a');
		assertTrue(sqlSession.update("com.spring.member.update", dto) == 1);
		dto = new MemberDTO();
		dto.setM_id("admin");
		dto.setM_nickname("admin");
		dto.setM_zipcode("999999");
		dto.setM_address1("test_Address1");
		dto.setM_address2("test_Address2");
		dto.setM_phone("010-2571-3495");
		dto.setM_email("ywyi1992@naver.com");
		assertTrue(sqlSession.update("com.spring.member.update", dto) == 1);
	}
	@Test
	public void testList() {
		List<MemberDTO> memberList = sqlSession.selectList("com.spring.member.select");
		assertNotNull(memberList);
		MemberDTO dto = memberList.get(0);
		assertEquals(dto.getRealGender(), "남자");
		assertEquals(dto.getRealGrant(), "운영자");
	}

	@Test
	public void testRead() {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberDTO dto = new MemberDTO();
		dto.setM_id("admin");
		map.put("memberDTO", dto);
		dto = sqlSession.selectOne("com.spring.member.select", map);
		assertEquals(dto.getRealGender(), "남자");
	}

	@Test
	public void testSearch() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchDTO", new SearchDTO("osm_m_name", "윤원용"));
		List<MemberDTO> list = sqlSession.selectList("com.spring.member.select", map);
		MemberDTO memberDTO = list.get(0);
		assertEquals(memberDTO.getRealGender(), "남자");
		assertEquals(memberDTO.getRealGrant(), "운영자");
	}



	@Test
	public void testDelete() {
		MemberDTO dto = new MemberDTO();
		dto.setM_id("admin"); 
		dto.setM_password("1234");
		assertTrue(sqlSession.delete("com.spring.member.delete", dto) == 1);
	}
	
	@Test
	public void testDuplicate() {
		DuplicateDTO ddto = new DuplicateDTO("osm_m_id", "admin"); 
		MemberDTO mdto = sqlSession.selectOne("com.spring.member.duplicate",ddto);
		assertNotNull(mdto);
	}
}
