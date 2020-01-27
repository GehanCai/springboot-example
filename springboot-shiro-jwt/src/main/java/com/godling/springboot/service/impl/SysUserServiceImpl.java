package com.godling.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godling.springboot.domain.dto.SysUserDTO;
import com.godling.springboot.domain.entity.SysUser;
import com.godling.springboot.mapper.SysUserMapper;
import com.godling.springboot.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * 业务实现
 *
 * @author cai
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUserDTO getByUsername(String username) {
        return baseMapper.getByUsername(username);
    }

}
