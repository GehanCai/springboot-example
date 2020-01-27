package com.godling.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.godling.springboot.domain.entity.SysRole;

import java.util.List;

/**
 * 业务接口
 *
 * @author cai
 */
public interface ISysRoleService extends IService<SysRole> {


    /**
     * 获取角色列表
     *
     * @param userId 用户编号
     * @return List
     */
    List<SysRole> listByUserId(Long userId);

}
