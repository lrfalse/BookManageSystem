package com.sdxmxy.bookmanage.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="BrStuInfo对象", description="")
public class BrStuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "借书证")
    private Long libCard;

    @TableId
    @ApiModelProperty(value = "图书编号")
    private String bookNum;

    @TableId
    @ApiModelProperty(value = "借书时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "bro_time", fill = FieldFill.INSERT)
    private Date broTime;

    @TableId
    @ApiModelProperty(value = "归还期限")
    private Date rnDeadline;

    @TableId
    @ApiModelProperty(value = "归还时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "rn_time", fill = FieldFill.INSERT_UPDATE)
    private Date rnTime;


}
