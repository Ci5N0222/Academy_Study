package commons.page;

import org.springframework.stereotype.Component;

@Component
public class PageDTO {
	private int currentPage;
	private int totalRecord;
	private int pageRecord;
	private int pageNavi;
	private String url;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageRecord() {
		return pageRecord;
	}
	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}
	public int getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(int pageNavi) {
		this.pageNavi = pageNavi;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public PageDTO(int currentPage, int totalRecord, int pageRecord, int pageNavi, String url) {
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.pageRecord = pageRecord;
		this.pageNavi = pageNavi;
		this.url = url;
	}
	
	public PageDTO() {}
	
	
	
}
