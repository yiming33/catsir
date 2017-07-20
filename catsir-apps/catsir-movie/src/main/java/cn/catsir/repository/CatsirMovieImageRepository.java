package cn.catsir.repository;

import cn.catsir.entity.CatsirMovieImage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CatsirMovieImageRepository extends BaseRepository<CatsirMovieImage, String> {

	@Select("select id, name, path, size, movie_id as movieId, create_date as createDate from catsir_movie_image where movie_id=#{movieId}")
	List<CatsirMovieImage> findByMovieId(String movieId);
}