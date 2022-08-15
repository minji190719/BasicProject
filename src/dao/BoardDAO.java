package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDAO {

	private static BoardDAO instance = null;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	String sql = null;

	public List<Map<String, Object>> showBoard() {
		sql = " SELECT * FROM BOARD "
				+ "ORDER BY BOARD_ID ASC";
		List<Map<String, Object>> rows = jdbc.selectList(sql);
		return rows;
	}

	public Map<String, Object> selectBoard(int input) {
		sql = " SELECT * FROM BOARD WHERE BOARD_ID=' " + input + " ' ";
		Map<String, Object> row = jdbc.selectOne(sql);
		return row;
	}

	public int writeBoard(List<Object> param) {
		sql = " INSERT INTO BOARD(                             "
				+ " BOARD_ID,                                  "
				+ " BOARD_DATE,                                "
				+ " BOARD_TITLE,                               "
				+ " BOARD_WRITE,                               "
				+ " BOARD_NICK,                                "
				+ " BOARD_PW)                                  "
				+ "                                            "
				+ " VALUES(                                    "
				+ "     SEQ_NUMBER_BOARD.nextval,              "
				+ "     SYSDATE,                               "
				+ "     ?,                                     "
				+ "     ?,                                     "
				+ "     ?,                                     "
				+ "     ?                                      "
				+ " )                                          ";
		return jdbc.update(sql, param);
	}

	public Map<String, Object> selectBoardPw(int selectedBoardId){
		//비회원일때
		sql =	" SELECT BOARD_PW "
				+ " FROM BOARD "
				+ " WHERE BOARD_ID = '" + selectedBoardId + "' ";
	//	Map<String, Object> row = jdbc.selectOne(sql);
		return jdbc.selectOne(sql);
		
	}

	public Map<String, Object> selectBoardNick(int selectedBoardId){
		//회원일때
		sql = " SELECT BOARD_NICK "
				+ " FROM BOARD "
				+ " WHERE BOARD_ID = '" + selectedBoardId + "' ";
		//	Map<String, Object> row = jdbc.selectOne(sql);
		return jdbc.selectOne(sql);
		
	}
	
	public int deleteBoard(int selectedBoardId) {
		sql = " DELETE FROM BOARD " + 
			  " WHERE BOARD_ID = '" + selectedBoardId + "' ";
							
		return jdbc.update(sql);
		
	}
	
	public int modifyBoard(int num, String value, int selectedBoardId) {
		sql = " UPDATE BOARD "
				+ " SET ";
		switch(num) {
		case 1:
			sql += " BOARD_TITLE = ";
			break;
		case 2:
			sql += "BOARD_WRITE = ";
			break;
		}		
		sql += " '" + value + "' ";
		sql +=  " WHERE BOARD_ID = '" + selectedBoardId + "' ";
		
		return jdbc.update(sql);
		
	}
	
	
	
}
