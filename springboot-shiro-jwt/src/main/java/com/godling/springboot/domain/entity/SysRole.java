package com.godling.springboot.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 数据实体
 *
 * @author cai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRole extends Model<SysRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 记录编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String code;

}
