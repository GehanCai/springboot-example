package com.godling.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godling.springboot.domain.entity.SysRole;
import com.godling.springboot.mapper.SysRoleMapper;
import com.godling.springboot.mapper.SysUserRoleMapper;
import com.godling.springboot.service.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务实现
 *
 * @author cai
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysRole> listByUserId(Long userId) {
        return sysUserRoleMapper.listByUserId(userId);
    }

}
