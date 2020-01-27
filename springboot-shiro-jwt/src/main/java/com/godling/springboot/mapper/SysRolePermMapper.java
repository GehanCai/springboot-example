package com.godling.springboot.mapper;

import com.godling.springboot.domain.entity.SysPerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据接口
 *
 * @author cai
 */
@Mapper
public interface SysRolePermMapper {
    /**
     * 获取权限列表
     *
     * @param roleIds 角色权限列表
     * @return List
     */
    List<String> listByRoleIds(@Param("roleIds") List<Long> roleIds);
}
