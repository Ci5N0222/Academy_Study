package content;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DatabasePool;

public class ContentDAO {

	DatabasePool dp = new DatabasePool();
	
	/**
	 * DB에 글을 저장하는 메서드
	 * @param writer
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public int addContent(String writer, String content) throws Exception {
		String sql = "insert into messages values(messages_seq.nextval, ?, ?, sysdate)";
		
		try(Connection con = dp.dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, writer);
			pstat.setString(2, content);
			return pstat.executeUpdate();
		}
	}
	
}
