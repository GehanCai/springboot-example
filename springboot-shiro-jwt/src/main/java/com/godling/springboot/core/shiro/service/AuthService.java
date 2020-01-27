package com.godling.springboot.core.shiro.service;

import com.godling.springboot.core.shiro.ShiroUtils;
import com.godling.springboot.core.shiro.exception.ShiroException;
import com.godling.springboot.core.shiro.exception.ShiroExceptionEnum;
import com.godling.springboot.domain.dto.SysUserDTO;
import com.godling.springboot.domain.entity.SysPerm;
import com.godling.springboot.domain.entity.SysRole;
import com.godling.springboot.service.ISysPermService;
import com.godling.springboot.service.ISysRoleService;
import com.godling.springboot.service.ISysUserService;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shiro 授权业务
 *
 * @author cai
 */
@Service
public class AuthService {

    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysPermService sysPermService;

    public SimpleAuthenticationInfo info(UsernamePasswordToken upToken, String realmName) {
        SysUserDTO user = sysUserService.getByUsername(upToken.getUsername());
        if (user == null) {
            throw new ShiroException(ShiroExceptionEnum.USER_NOT_EXIST);
        }
        // 设置角色
        List<SysRole> roles = sysRoleService.listByUserId(user.getId());
        if (roles.isEmpty()) {
            throw new ShiroException(ShiroExceptionEnum.USER_ROLE_EMPTY);
        }
        user.setRoles(roles.stream().map(SysRole::getCode).collect(Collectors.toList()));
        // 设置权限
        List<String> perms = sysPermService.getPermsByRoleIds(roles.stream().map(SysRole::getId).collect(Collectors.toList()));
        user.setPerms(perms);

        ByteSource salt = ShiroUtils.getSalt(user.getUsername(), user.getSalt());
        return new SimpleAuthenticationInfo(user, user.getPassword(), salt, realmName);
    }

}
