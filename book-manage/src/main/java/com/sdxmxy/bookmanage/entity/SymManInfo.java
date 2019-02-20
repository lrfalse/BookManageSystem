package com.sdxmxy.bookmanage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Sdxmxy
 * @since 2018-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="管理员对象", description="")
public class SymManInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "管理员编号")
    private String symNum;

    @TableId
    @ApiModelProperty(value = "管理员名字")
    private String symName;

    @TableId
    @ApiModelProperty(value = "管理员密码")
    private String symPass;


}
