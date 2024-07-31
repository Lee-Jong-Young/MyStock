package com.gn.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionTemplate {
	//1.static 메소드 만듬 
//	sqlSession 리턴함
	public static SqlSession getSqlSession() {
//		6.SqlSession 선언부 빼주기
		SqlSession session= null;
		//2. try catch문 안에 넣어주기
		try {
			// 1. mybatis-config.xml의 설정 정보 읽어오기
			String path = "/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(path);
			// 3. SqlSessionFactoryBuilder 객체 생성
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			// 4. SqlSessionFactoryBuilder 객체의 build() 메소드 활용
			// SqlSessionFactory 객체 생성
			SqlSessionFactory factory = sfb.build(is);
			// 5. SqlSessionFactory 객체의 OpenSession() 메소드 활용
//			SqlSession 객체 생성
			// 매개변수로 AutoCommit 여부 지정(default : true) factory open 세션이 false 헛소리임 default값은 true임
			session = factory.openSession(true);			
		}catch(IOException e)	 {
			e.printStackTrace();
		}
		return session;
	}
}
