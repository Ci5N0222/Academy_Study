package dao;

import java.time.LocalDate;
import java.util.ArrayList;

import dto.MovieDTO;

public class MovieDAO {

	/** Movie Data Save **/
	ArrayList<MovieDTO> movies = new ArrayList<MovieDTO>();
	
	/** AI index **/
	int index = 1001;
	
	/** Get index **/
	public int getIndex() {
		return index;
	}

	
	/**
	 * Add movie
	 * @param title
	 * @param genre
	 * @return
	 */
	public String addMovie(String title, String genre) {
		String result = "";
		
		try {
			movies.add(new MovieDTO(index, title, genre));
			result = "영화 등록에 성공하였습니다";
			index ++;
			
		} catch (Exception e) {
			result = "Error : " + e;
		}
		
		return result;
				
	}

	
	/**
	 * Get Movie list
	 * @return
	 */
	public ArrayList<MovieDTO> movieList() {
		return movies;
	}
	

	/**
	 * Search Movies
	 * @param title
	 * @return
	 */
	public ArrayList<MovieDTO> searchMovies(String title) {
		ArrayList<MovieDTO> searchMovies = new ArrayList<MovieDTO>();
		for(MovieDTO movie: movies) {
			if(movie.getTitle().contains(title)) {
				searchMovies.add(movie);
			}
		}
		return searchMovies;
	}
	

	/**
	 * Delete movie
	 * @param id
	 * @return
	 */
	public String deleteMovie(int id) {
		String result = "삭제 오류 발생!!";
		for(MovieDTO movie: movies) {
			if(movie.getId() == id) {
				int index = movies.indexOf(movie);
				movies.remove(index);
				result = "삭제가 정상적으로 처리되었습니다.";
				break;
			}
		}
		
		return result;
	}
	

	/**
	 * Update movie
	 * @param id
	 * @param title
	 * @param genre
	 * @return
	 */
	public String updateMovie(int id, String title, String genre) {
		String result = "업데이트 오류 발생!!";
		for(MovieDTO movie: movies) {
			if(movie.getId() == id) {
				movie.setTitle(title);
				movie.setGenre(genre);
				movie.setWrite_date(LocalDate.now());
				result = "업데이트가 정상적으로 처리되었습니다.";
				break;
			}
		}
		
		return result;
	}
	 
	
}
