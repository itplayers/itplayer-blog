package com.itplayer.common.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itplayer.common.base.entity.BaseEntity;
import com.itplayer.common.base.mapper.CustomBaseMapper;
import com.itplayer.common.base.query.BaseQueryModel;
import com.itplayer.common.base.service.BaseService;
import com.itplayer.common.serialutils.SerNumUtils;
import com.itplayer.utils.common.StrUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class BaseServiceImpl<T extends BaseEntity, PK extends Serializable> implements BaseService<T, PK> {

    protected CustomBaseMapper mapper = null;

    public void setMapper(CustomBaseMapper mapper) {
        this.mapper = mapper;
    }

    public void generateSerNum(T t) {
        String serialNo = t.getSerialNo();
        if (StrUtils.isNull(serialNo)) {
            t.setSerialNo(SerNumUtils.getSerNum(t));
        }
    }

    @Override
    public int insert(T t) {
        generateSerNum(t);
        Date date = new Date();
        t.setCreateDate(date);
        t.setUpdateDate(date);
        return mapper.insert(t);
    }

    @Override
    public int deleteById(PK id) {
        return mapper.deleteById(id);
    }

    @Override
    public int deleteBatchIds(Collection<? extends PK> ids) {
        return mapper.deleteBatchIds(ids);
    }

    @Override
    public int updateById(T t) {
        return mapper.updateById(t);
    }

    @SuppressWarnings("unchecked")
	@Override
    public T selectById(PK id) {
        return (T) mapper.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends PK> ids) {
        return mapper.selectBatchIds(ids);
    }

    @Override
    public IPage<T> selectPage(BaseQueryModel queryModel) {
        IPage<T> pages = mapper.selectPage(new Page<>(queryModel.getCurrentPage(), queryModel.getPageSize()), queryModel.getWrapper());
        return pages;
    }

	@Override
	public List<T> selectList(Wrapper<T> queryWrapper) {
		return mapper.selectList(queryWrapper);
	}

	@Override
	public int delete(Wrapper<T> queryWrapper) {
		return mapper.delete(queryWrapper);
	}
	
}
