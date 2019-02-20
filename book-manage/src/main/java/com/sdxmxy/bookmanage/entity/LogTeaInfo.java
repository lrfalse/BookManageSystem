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
@ApiModel(value="LogTeaInfo对象", description="")
public class LogTeaInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "借书证号")
    private Long libCard;

    @TableId
    @ApiModelProperty(value = "职工号")
    private String teaNum;

    @TableId
    @ApiModelProperty(value = "密码")
    private String teaPass;


}
