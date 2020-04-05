package com.spring.index.jdbc;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class JdbcTest {
	@Resource(name = "dateSource")
	private DataSource db;
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sf;
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@BeforeClass
	public void testBeanCheck() throws Exception {
		assertNotNull(db);
		assertNotNull(sf);
		assertNotNull(sqlSession);
	}

}
