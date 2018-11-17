package com.itplayer.common.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class MetaEntity extends BaseEntity {
    @TableField("id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
