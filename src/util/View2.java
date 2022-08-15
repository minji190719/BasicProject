package util;

public interface View2 {
	
	// 홈 -- 전재한
	int HOME = 1;
	int SIGNUP = 11;
	int LOGIN = 12;
	int LOGOUT = 13;
	
	
	// 유저   -- 전재한
	int USER = 2;
	int USER_STATUS = 21;
	int USER_MODIFY = 22;
	int USER_PASS = 23;
	int USER_DRAMA = 24;
	int USER_REVIEW = 25;
	int USER_BOARD = 26;
	
	
	// 게시판  -- 박민지     // BoardService, BoardDAO
	int BOARD = 3;
	int BOARD_WRITE = 31;
	int BOARD_SELECT = 32;
	int BOARD_MODIFY = 33;
	int BOARD_DELETE = 34;
	
	
	// 연극 -- 오지형    // DramaService, DramaDAO
	int DRAMA = 4;
	int DRAMA_INFO = 41;
	int DRAMA_REVIEW = 42;
	int DRAMA_TICKETTING = 44;
	int DRAMA_REFUND = 45;
	
	
	// 리뷰  -- 김슬기    // ReviewService, ReviewDAO
	int REVIEW = 5;
	int REVIEW_WRITE = 51;
	int REVIEW_SELECT = 52;
	int REVIEW_MODIFY = 53;
	int REVIEW_DELETE = 54;

	
	
	
	

}
