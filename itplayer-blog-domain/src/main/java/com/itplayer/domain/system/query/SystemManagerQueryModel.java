package com.itplayer.domain.system.query;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itplayer.common.base.query.BaseQueryModel;
import com.itplayer.domain.system.entity.SystemManager;
import com.itplayer.utils.common.StrUtils;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class SystemManagerQueryModel extends BaseQueryModel<SystemManager> {

    private String username;


    @Override
    public Wrapper<SystemManager> createPageQueryWrappe() {
        QueryWrapper<SystemManager> pageQueryWrappe = new QueryWrapper<SystemManager>();
        if (StrUtils.isNotNull(username)) {
            pageQueryWrappe.lambda().eq(SystemManager::getUsername, username);
        }
        return pageQueryWrappe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
