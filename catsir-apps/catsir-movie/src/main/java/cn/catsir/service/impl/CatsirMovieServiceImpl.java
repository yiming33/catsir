package cn.catsir.service.impl;

import cn.catsir.entity.CatsirMovie;
import cn.catsir.model.CatsirMovieModel;
import cn.catsir.repository.BaseRepository;
import cn.catsir.repository.CatsirMovieImageRepository;
import cn.catsir.repository.CatsirMovieRepository;
import cn.catsir.service.CatsirMovieService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.github.pagehelper.PageHelper.startPage;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

/**
 * Created by YiMing on 2017/7/12.
 */
@Service("catsirMovieService")
public class CatsirMovieServiceImpl implements CatsirMovieService {

	@Autowired
	private CatsirMovieRepository catsirMovieRepository;

	@Autowired
	private CatsirMovieImageRepository catsirMovieImageRepository;

	@Override
	public BaseRepository<CatsirMovie, String> getRepository() {
		return catsirMovieRepository;
	}

	@Override
	public PageInfo<CatsirMovieModel> findMovies() {
		startPage(0, 30);
		List<CatsirMovieModel> movies = catsirMovieRepository.findMovies();
		long start = System.currentTimeMillis();
		PageInfo<CatsirMovieModel> p = new PageInfo<>(movies);
		p.getList().stream().map(movie -> supplyAsync(() -> catsirMovieImageRepository.findByMovieId(movie.getId()))
				.thenCompose(images -> supplyAsync(() -> {
					movie.setImages(images);
					return movie;
				}))).collect(toList()).stream().forEach(CompletableFuture::join);
		System.out.println(System.currentTimeMillis()-start);
		return p;
	}
}
