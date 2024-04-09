package dto;

import java.time.LocalDate;

public class MusicDTO {
	
	/** Field **/
	private int id;
	private String title;
	private String singer;
	private LocalDate write_date;
	private LocalDate update_date;
	
	
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

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public LocalDate getWrite_date() {
		return write_date;
	}

	public void setWrite_date(LocalDate write_date) {
		this.write_date = write_date;
	}
	
	public LocalDate getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDate update_date) {
		this.update_date = update_date;
	}

	
	
	/** constructor **/
	public MusicDTO() {
		
	}

	public MusicDTO(int id, String title, String singer) {
		super();
		this.id = id;
		this.title = title;
		this.singer = singer;
		this.write_date = LocalDate.now();
		this.update_date = null;
	}
	
}
