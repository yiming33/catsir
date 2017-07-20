package cn.catsir.service;

import cn.catsir.entity.CatsirMovie;
import cn.catsir.model.CatsirMovieModel;
import com.github.pagehelper.PageInfo;

/**
 * Created by YiMing on 2016/11/11.
 */
public interface CatsirMovieService extends BaseService<CatsirMovie, String> {

	PageInfo<CatsirMovieModel> findMovies();
}
