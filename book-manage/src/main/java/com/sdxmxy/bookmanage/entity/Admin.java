package com.sdxmxy.bookmanage.entity;
/**
 * <p>
 *
 * </p>
 *
 * @author Sdxmxy
 * @since 2018-12-26
 */

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "管理员Id")
    private String id;

    @TableId
    @ApiModelProperty(value = "管理员密码")
    private String passwd;

    @TableId
    @ApiModelProperty(value = "管理员昵称")
    private String nickName;

}
