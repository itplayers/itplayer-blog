package com.itplayer.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itplayer.common.base.controller.BaseController;
import com.itplayer.common.base.resp.ResponseData;
import com.itplayer.domain.system.entity.SystemManager;
import com.itplayer.domain.system.query.SystemManagerQueryModel;
import com.itplayer.system.service.SystemManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
@RestController
@RequestMapping(value = "/sys/systemManager")
public class ManagerController extends BaseController {


//    @Autowired
//    RedisClient redisClient;
	
    @Autowired
    SystemManagerService managerService;

    @GetMapping("/{serialNo}")
    public ResponseData getOne(@PathVariable("serialNo") String serialNo) {
    	System.out.println(serialNo);
        SystemManager systemManager = managerService.selectById(serialNo);
        return success(systemManager);
    }
    
    @PostMapping("/create")
    public ResponseData create(@RequestBody SystemManager systemManager) {
        managerService.insert(systemManager);
        return success();
    }
    @PostMapping("/update")
    public ResponseData update(@RequestBody SystemManager systemManager) {
        managerService.updateById(systemManager);
        return success();
    }
    @GetMapping("/delete/{serialNo}")
    public ResponseData delete(@PathVariable("serialNo") String serialNo) {
       managerService.deleteById(serialNo);
        return success();
    }
    @PostMapping("/list")
    public ResponseData page(@RequestBody SystemManagerQueryModel queryModel) {
        IPage<SystemManager> managerPage = managerService.selectPage(queryModel);
        return success(managerPage);
    }

}
