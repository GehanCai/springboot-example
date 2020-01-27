package com.godling.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godling.springboot.domain.entity.SysPerm;
import com.godling.springboot.mapper.SysPermMapper;
import com.godling.springboot.mapper.SysRolePermMapper;
import com.godling.springboot.service.ISysPermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务实现
 *
 * @author cai
 */
@Service
public class SysPermServiceImpl extends ServiceImpl<SysPermMapper, SysPerm> implements ISysPermService {

    @Resource
    private SysRolePermMapper sysRolePermMapper;

    @Override
    public List<String> getPermsByRoleIds(List<Long> roleIds) {
        return sysRolePermMapper.listByRoleIds(roleIds);
    }
}
