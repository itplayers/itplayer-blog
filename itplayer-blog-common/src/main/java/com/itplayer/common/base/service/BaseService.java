package com.itplayer.common.base.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itplayer.common.base.entity.BaseEntity;
import com.itplayer.common.base.query.BaseQueryModel;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public interface BaseService<T extends BaseEntity, PK extends Serializable> {
    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(PK id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatchIds(@Param("coll") Collection<? extends PK> ids);

    /**
     * 更新
     * @param t
     * @return
     */
    int updateById(@Param("et") T t);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T selectById(PK id);

    /**
     * 根据多个id查询
     * @param id
     * @return
     */
    List<T> selectBatchIds(@Param("coll") Collection<? extends PK> id);

    /**
     * 分页查询
     * @param queryModel
     * @return
     */
	IPage<T> selectPage(BaseQueryModel queryModel);
	
	/**
     * 根据实体属性查询
     * @param queryWrapper
     * @return
     */
	List<T> selectList(Wrapper<T> queryWrapper);
	
	/**
     * 根据实体属性删除
     * @param queryWrapper
     * @return
     */
	int delete(Wrapper<T> queryWrapper);

}
