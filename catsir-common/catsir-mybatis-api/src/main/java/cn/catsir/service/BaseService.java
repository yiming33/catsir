package cn.catsir.service;

import cn.catsir.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YiMing on 2017/7/13.
 */
public interface BaseService<T, ID extends Serializable> {

	BaseRepository<T, ID> getRepository();

	default int deleteById(ID id) {
		return getRepository().deleteById(id);
	}

	default int save(T t) {
		return getRepository().save(t);
	}

	default int insertSelective(T t) {
		return getRepository().insertSelective(t);
	}

	default T findById(ID id) {
		return getRepository().findById(id);

	}

	default int updateByIdSelective(T t) {
		return getRepository().updateByIdSelective(t);
	}

	default int updateById(T t) {
		return getRepository().updateById(t);
	}

	default List<T> findAll() {
		return getRepository().findAll();
	}
}
