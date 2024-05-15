package dto;

public class MemberDTO {

	/** MemberDTO **/
	private String id;
	private String pw;
	private String name;
	
	/** Getter & Setter **/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/** Constructor **/
	public MemberDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public MemberDTO() {
		
	}
	
}
