package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class RootDAO {

	private static RootDAO instance = null;

	private RootDAO() {
	}

	public static RootDAO getInstance() {
		if (instance == null) {
			instance = new RootDAO();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	String sql = null;

	public int signUp(List<Object> param) {
		sql = " INSERT INTO CLIENT(                             "
				+ " USER_ID,                                    "
				+ " USER_PW,                                    "
				+ " USER_NICK,                                  "
				+ " USER_NAME,                                  "
				+ " USER_BIRTH,                                 "
				+ " USER_PHONE,                                 "
				+ " USER_EMAIL)                                 "
				+ "                                             "
				+ " VALUES(                                     "
				+ "     ?,                                      "
				+ "     ?,                                      "
				+ "     ?,                                      "
				+ "     ?,                                      "
				+ "     TO_DATE(?),                             "
				+ "     ?,                                      "
				+ "     ?                                       "
				+ " )                                           ";
		return jdbc.update(sql, param);
	}

	public Map<String, Object> login(String userID, String userPass) {
		sql = "     SELECT *                                                  "
				+ "   FROM CLIENT                                             "
				+ "  WHERE USER_ID='" + userID + "'                           "
				+ "        AND USER_PW='" + userPass + "'                     ";
		Map<String, Object> row = jdbc.selectOne(sql);
		return row;
	}

}
