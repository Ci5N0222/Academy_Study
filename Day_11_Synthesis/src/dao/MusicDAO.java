package dao;

import java.time.LocalDate;
import java.util.ArrayList;

import dto.MusicDTO;

public class MusicDAO {
	
	/** Data save collection **/
	ArrayList<MusicDTO> music = new ArrayList<MusicDTO>();
	int id = 1001;
	
	
	/**
	 * Get id(auto increment)
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Add new music
	 * @param ms
	 */
	public int addMusic(MusicDTO ms) {
		int result = 0;
		
		try {
			music.add(ms);
			id++;
			result = 1;
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		return result;
		
	}
	
	
	/**
	 * Music list
	 * @return
	 */
	public ArrayList<MusicDTO> musicList() {
		return music;
	}
	
	
	/**
	 * Search all music
	 * @param title
	 * @return
	 */
	public ArrayList<MusicDTO> searchAllMusic(String title) {
		ArrayList<MusicDTO> result = new ArrayList<MusicDTO>(); 
		
		try {
			for(MusicDTO detail: music) {
				if(detail.getTitle().contains(title)) {
					result.add(detail);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		return result;
	}
	
	
	/**
	 * Search one music
	 * @param id
	 * @return
	 */
	public MusicDTO searchMusic(int id) {
		
		try {
			for(MusicDTO detail: music) {
				if(detail.getId() == id) {
					return detail;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		return null;
	}
	
	
	/**
	 * Delete music
	 * @param id
	 * @return
	 */
	public int deleteMusic(int id) {
		int result = 0;
		
		try {
			music.removeIf((item) -> item.getId() == id);
			result = 1;

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		return result;
	}
	
	
	/**
	 * Update music
	 * @param ms
	 * @return
	 */
	public int updateMusic(MusicDTO ms) {
		int result = 0;
		
		try {
			for(MusicDTO detail: music) {
				if(detail.getId() == ms.getId()) {
					detail.setTitle(ms.getTitle());
					detail.setSinger(ms.getSinger());
					detail.setUpdate_date(LocalDate.now());
					result = 1;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		return result;
	}
	
}
