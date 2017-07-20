package cn.catsir.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YiMing on 2017/7/12.
 */
public interface BaseRepository<T, ID extends Serializable> {

	int deleteById(ID id);

	int save(T t);

	int insertSelective(T t);

	T findById(ID id);

	int updateByIdSelective(T t);

	int updateById(T t);

	List<T> findAll();

}
