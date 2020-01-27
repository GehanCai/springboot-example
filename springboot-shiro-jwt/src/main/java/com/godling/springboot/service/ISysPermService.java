package com.godling.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.godling.springboot.domain.entity.SysPerm;

import java.util.List;

/**
 * 业务接口
 *
 * @author cai
 */
public interface ISysPermService extends IService<SysPerm> {

    /**
     * 获取权限列表
     *
     * @param roleIds 角色编号列表
     * @return List
     */
    List<String> getPermsByRoleIds(List<Long> roleIds);

}
