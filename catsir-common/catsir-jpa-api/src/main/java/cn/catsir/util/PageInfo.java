package cn.catsir.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by YiMing on 2017/7/13.
 */
public class PageInfo<T> {
	private Pageable pageable;

	private Page<T> page;

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
