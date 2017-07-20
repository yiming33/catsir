package cn.catsir.util;

import cn.catsir.entity.CatsirMovie;
import cn.catsir.model.CatsirMovieModel;

/**
 * Created by YiMing on 2017/7/14.
 */
public class ModelConvertUtil {

	public static CatsirMovieModel convertToCatsirMovieModel(CatsirMovie movie) {
        CatsirMovieModel movieModel = new CatsirMovieModel();
        movieModel.setId(movie.getId());
        movieModel.setTranslateName(movie.getTranslateName());
		return movieModel;
	}
}
