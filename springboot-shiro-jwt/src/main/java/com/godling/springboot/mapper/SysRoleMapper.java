package com.godling.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.godling.springboot.domain.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据接口
 *
 * @author cai
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
}
