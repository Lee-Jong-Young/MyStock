package com.gn.user.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.gn.user.dao.UserDao;
import com.gn.user.vo.User;

public class UserService {
	public int createUser(User u) {
		Connection conn = getConnection();
		int resultvo = new UserDao().createUser(u,conn);
		close(conn);
		return resultvo;
	}
}
