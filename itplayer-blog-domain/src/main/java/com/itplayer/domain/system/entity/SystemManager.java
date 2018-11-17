package com.itplayer.domain.system.entity;

import com.itplayer.common.base.entity.MetaEntity;

/**
 * @author caijun.yang
 * @date 2018/11/16
 */
public class SystemManager extends MetaEntity {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
