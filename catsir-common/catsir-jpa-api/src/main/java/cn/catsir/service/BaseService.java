package cn.catsir.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

import static cn.catsir.util.PageUtil.*;

/**
 * Created by YiMing on 2017/7/12.
 */
public interface BaseService<T, ID extends Serializable> {

	JpaRepository<T, ID> getRepository();

	default List<T> findAll() {
		Page<T> page = getRepository().findAll(getLocalPage());
		setPage(page);
		return page.getContent();
	}

	default List<T> findAll(Sort sort) {
		Pageable pageable = getLocalPage();
		if (pageable != null) {
			Page<T> page = getRepository().findAll(range(pageable, sort));
			setPage(page);
			return page.getContent();
		} else {
			return getRepository().findAll(sort);
		}
	}

	default List<T> findAll(Iterable<ID> iterable) {
		return getRepository().findAll(iterable);
	}

	default <S extends T> List<S> save(Iterable<S> iterable) {
		return getRepository().save(iterable);
	}

	default <S extends T> S saveAndFlush(S s) {
		return getRepository().saveAndFlush(s);
	}

	default void deleteInBatch(Iterable<T> iterable) {
		getRepository().deleteInBatch(iterable);
	}

	default void deleteAllInBatch() {
		getRepository().deleteAllInBatch();
	}

	default T getOne(ID id) {
		return getRepository().getOne(id);
	}

	default <S extends T> List<S> findAll(Example<S> example) {
		return getRepository().findAll(example);
	}

	default <S extends T> List<S> findAll(S s) {
		return getRepository().findAll(Example.of(s));
	}

	default <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		Pageable pageable = getLocalPage();
		if (pageable != null) {
			Page<S> page = getRepository().findAll(example, range(pageable, sort));
			setPage(page);
			return page.getContent();
		} else {
			return getRepository().findAll(example, sort);
		}
	}

	default Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable == null ? getLocalPage() : pageable);
	}

	default <S extends T> S save(S s) {
		return getRepository().save(s);
	}

	default T findOne(ID id) {
		return getRepository().getOne(id);
	}

	default boolean exists(ID id) {
		return getRepository().exists(id);
	}

	default long count() {
		return getRepository().count();
	}

	default void delete(ID id) {
		getRepository().delete(id);
	}

	default void delete(T t) {
		getRepository().delete(t);
	}

	default void delete(Iterable<? extends T> iterable) {
		getRepository().delete(iterable);
	}

	default void deleteAll() {
		getRepository().deleteAll();
	}

	default <S extends T> S findOne(Example<S> example) {
		return getRepository().findOne(example);
	}

	default <S extends T> S findOne(S s) {
		return getRepository().findOne(Example.of(s));
	}

	default <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return getRepository().findAll(example, pageable == null ? getLocalPage() : pageable);
	}

	default <S extends T> Page<S> findAll(S s, Pageable pageable) {
		return getRepository().findAll(Example.of(s), pageable == null ? getLocalPage() : pageable);
	}

	default <S extends T> long count(Example<S> example) {
		return getRepository().count(example);
	}

	default <S extends T> long count(S s) {
		return getRepository().count(Example.of(s));
	}

	default <S extends T> boolean exists(Example<S> example) {
		return getRepository().exists(example);
	}

	default <S extends T> boolean exists(S s) {
		return getRepository().exists(Example.of(s));
	}

}
