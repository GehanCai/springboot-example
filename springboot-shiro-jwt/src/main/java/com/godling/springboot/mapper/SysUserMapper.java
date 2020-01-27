package com.godling.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.godling.springboot.domain.dto.SysUserDTO;
import com.godling.springboot.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据接口
 *
 * @author cai
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {


    /**
     * 通过用户名查询记录
     *
     * @param username 用户名
     * @return SysUserDTO
     */
    SysUserDTO getByUsername(String username);


}
