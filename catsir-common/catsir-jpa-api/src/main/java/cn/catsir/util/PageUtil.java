package cn.catsir.util;

import org.springframework.data.domain.*;

/**
 * Created by YiMing on 2017/7/12.
 */
public class PageUtil {

	private static final ThreadLocal<PageInfo> LOCAL_PAGE = new ThreadLocal<>();

	/**
	 * 获取Page参数
	 *
	 * @return
	 */
	public static Pageable getLocalPage() {
		PageInfo pageInfo = LOCAL_PAGE.get();
		return pageInfo == null ? null : pageInfo.getPageable();
	}

	/**
	 * 获取Page参数
	 *
	 * @return
	 */
	public static PageInfo getLocalPageInfo() {
		return LOCAL_PAGE.get();
	}

	private static Pageable setLocalPage(Pageable page) {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageable(page);
		LOCAL_PAGE.set(pageInfo);
		return page;
	}

	/**
	 * 移除本地变量
	 */
	public static void clearLocalPage() {
		LOCAL_PAGE.remove();
	}

	/**
	 *
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 */
	public static Pageable range(int pageNum, int pageSize) {
		return setLocalPage(new PageRequest(pageNum == 0 ? 0 : pageNum - 1, pageSize));

	}

	/**
	 *
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 * @param sort 排序
	 */
	public static Pageable range(int pageNum, int pageSize, Sort sort) {
		return setLocalPage(new PageRequest(pageNum == 0 ? 0 : pageNum - 1, pageSize, sort));
	}

	/**
	 * 
	 * @param pageable 分页类
	 * @param sort 排序
	 */
	public static Pageable range(Pageable pageable, Sort sort) {
		return setLocalPage(new PageRequest(pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1,
				pageable.getPageSize(), sort));
	}

	/**
	 *
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 * @param asc true为正序 false为逆序
	 * @param orderBy 排序字段
	 */
	public static Pageable range(int pageNum, int pageSize, boolean asc, String... orderBy) {
		return setLocalPage(new PageRequest(pageNum == 0 ? 0 : pageNum - 1, pageSize,
				asc ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy));
	}

	/**
	 *
	 * @param pageNum 页码
	 * @param pageSize 每页显示数量
	 * @param orderBy 排序字段
	 */
	public static Pageable range(int pageNum, int pageSize, String... orderBy) {
		return setLocalPage(new PageRequest(pageNum == 0 ? 0 : pageNum - 1, pageSize, Sort.Direction.ASC, orderBy));
	}

	/**
	 *
	 */
	public static <T> PageImpl<T> getPageImpl() {
		Page<T> page = getLocalPageInfo().getPage();
		return new PageImpl<>(page.getContent(), getLocalPage(), page.getTotalElements());
	}

	/**
	 *
	 */
	public static <T> void setPage(Page<T> page) {
		getLocalPageInfo().setPage(page);
	}

}
