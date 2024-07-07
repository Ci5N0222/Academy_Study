package commons.page;

public class PageConfig {
	
	// 한 페이지에서 보여줄 레코드, 네비 개수
	public static int BOARD_RECORD_PAGE = 5;
	public static int BOARD_NAVI_PAGE = 10;
	
	public static int REPLY_RECORD_PAGE = 10;
	public static int REPLY_NAVI_PAGE = 10;

	// 페이징 처리 시 사용할 URL
	public static String BOARD_PAGE = "/board/list";

	public static String REPLY_PAGE = "/board/detail";

}
