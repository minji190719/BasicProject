package dao;

import java.util.Map;

import controller.ControllerV2;
import util.JDBCUtil;

public class UserDAO {

	private static UserDAO instance = null;

	private UserDAO() {
	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	String sql = null;

	public Map<String, Object> getUserInfo() {
		Object userID = ControllerV2.userInfo.get("USER_ID");
		sql = " SELECT * FROM CLIENT WHERE USER_ID='" + userID + "'";
		Map<String, Object> row = jdbc.selectOne(sql);
		return row;
	}

	public int userModify(int userNum, String userValue) {
		sql = " UPDATE CLIENT SET ";
		switch (userNum) {
		case 1:
			sql += " USER_NICK= ";
			break;
		case 2:
			sql += " USER_NAME= ";
			break;
		case 3:
			sql += " USER_BIRTH= ";
			break;
		case 4:
			sql += " USER_PHONE= ";
			break;
		case 5:
			sql += " USER_EMAIL= ";
			break;

		default:
			break;
		}
		sql += "  '" + userValue + "' ";
		sql += " WHERE USER_ID='" + ControllerV2.userInfo.get("USER_ID") + "' ";
		int result = jdbc.update(sql);
		return result;
	}

	public int modifyPass(String anotherPass) {
		Object userID = ControllerV2.userInfo.get("USER_ID");
		sql = "    UPDATE CLIENT                                              "
				+ "   SET USER_PW='" + anotherPass + "'                       "
				+ " WHERE USER_ID='" + userID + "'                            ";
		int result = jdbc.update(sql);
		return result;
	}

}
