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
@ApiModel(value="LogStuInfo对象", description="")
public class LogStuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "借书证号")
    private Long libCard;

    @TableId
    @ApiModelProperty(value = "学号")
    private String stuNum;

    @TableId
    @ApiModelProperty(value = "密码")
    private String stuPass;


}
