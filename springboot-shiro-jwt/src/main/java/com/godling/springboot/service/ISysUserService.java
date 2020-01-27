package com.godling.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.godling.springboot.domain.dto.SysUserDTO;
import com.godling.springboot.domain.entity.SysUser;

/**
 * 业务接口
 *
 * @author cai
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 通过用户名查询数据
     *
     * @param username 用户名
     * @return 数据
     */
    SysUserDTO getByUsername(String username);

}
