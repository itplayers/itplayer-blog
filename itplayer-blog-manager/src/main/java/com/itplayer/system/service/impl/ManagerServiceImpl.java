package com.itplayer.system.service.impl;

import com.itplayer.common.base.service.impl.BaseServiceImpl;
import com.itplayer.domain.system.entity.SystemManager;
import com.itplayer.domain.system.mapper.SystemManagerMapper;
import com.itplayer.system.service.SystemManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author caijun.yang
 * @date 2018/10/26
 */
@Service
public class ManagerServiceImpl extends BaseServiceImpl<SystemManager, String> implements SystemManagerService {

    SystemManagerMapper managerMapper;

    @Autowired
    public void setManagerMapper(SystemManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
        super.setMapper(managerMapper);
    }
}
