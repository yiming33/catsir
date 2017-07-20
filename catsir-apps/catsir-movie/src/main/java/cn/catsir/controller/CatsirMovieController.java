package cn.catsir.controller;

import cn.catsir.entity.CatsirMovie;
import cn.catsir.model.CatsirMovieModel;
import cn.catsir.service.CatsirMovieService;
import cn.catsir.util.IdGenerator;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by YiMing on 2017/7/12.
 */
@RestController
@RequestMapping("/catsirMovie")
public class CatsirMovieController {

	@Autowired
	private CatsirMovieService catsirMovieService;

	@RequestMapping("/save")
	public CatsirMovie save() {
		CatsirMovie movie = new CatsirMovie();
		movie.setId(IdGenerator.newId());
		movie.setName("易明传");
		movie.setCreateDate(new Date());
		movie.setBriefInfo("简介");
		movie.setDirector("易明");
		movie.setRegion("中国");
		movie.setScore("豆瓣评分：9.9");
		movie.setReleaseDate(new Date());
		movie.setLanguage("汉语");
		movie.setTime(90);
		movie.setLastUpdateDate(new Date());
		movie.setStar("易明");
		movie.setTranslateName("易明传");
		catsirMovieService.save(movie);
		return movie;
	}

	// @RequestMapping("/findAll")
	// public PageImpl<CatsirMovie> findAll(int pageNo, int pageSize) {
	// range(pageNo, pageSize);
	// catsirMovieService.findAll();
	// return getPageImpl();
	// }

	@RequestMapping("/findMovies")
	public PageInfo<CatsirMovieModel> findMovies() {
		return catsirMovieService.findMovies();
	}

}
