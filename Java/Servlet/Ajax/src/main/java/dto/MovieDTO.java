package dto;

public class MovieDTO {
	
	/** MovieDTO **/
	private int seq;
	private String title;
	private String genre;
	
	
	/** Getter & Setter **/
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	/** Constructor **/
	public MovieDTO(int seq, String title, String genre) {
		super();
		this.seq = seq;
		this.title = title;
		this.genre = genre;
	}
	
	public MovieDTO() {
		super();
	}
	
	
}
