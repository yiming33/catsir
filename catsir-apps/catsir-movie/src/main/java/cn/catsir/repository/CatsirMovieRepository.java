package cn.catsir.repository;

import cn.catsir.entity.CatsirMovie;
import cn.catsir.model.CatsirMovieModel;

import java.util.List;

public interface CatsirMovieRepository extends BaseRepository<CatsirMovie, String> {

//	@Select("select id,release_date as releaseDate,translate_name as translateName from catsir_movie")
	List<CatsirMovieModel> findMovies();

}