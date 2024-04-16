package dto;

import java.time.LocalDate;

public class MovieDTO {
	
	
	/** MovieDTO **/
	private int id;
	private String title;
	private String genre;
	private LocalDate write_date;
	
	
	/** getter & setter **/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public LocalDate getWrite_date() {
		return write_date;
	}
	public void setWrite_date(LocalDate write_date) {
		this.write_date = write_date;
	}

	
	/** Constructor **/
	public MovieDTO(int id, String title, String genre) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.write_date = LocalDate.now();
	}
	
	public MovieDTO() {
		
	}
	
}
