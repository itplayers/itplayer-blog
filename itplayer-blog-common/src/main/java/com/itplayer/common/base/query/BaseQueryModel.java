package com.itplayer.common.base.query;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.io.Serializable;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class BaseQueryModel<T> implements Serializable {

    private int pageSize = 10;

    private int currentPage = 1;


	public Wrapper<T> createPageQueryWrappe() {
    	Wrapper<T> wrapper  = new QueryWrapper<T>();
    	return wrapper;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


	public Wrapper<T> getWrapper() {
        return createPageQueryWrappe();
	}
    
}
