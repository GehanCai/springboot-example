package com.godling.springboot.mapper;

import com.godling.springboot.domain.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据接口
 *
 * @author cai
 */
@Mapper
public interface SysUserRoleMapper {

    /**
     * 获取角色列表
     *
     * @param userId 用户编号
     * @return List
     */
    List<SysRole> listByUserId(Long userId);

}
