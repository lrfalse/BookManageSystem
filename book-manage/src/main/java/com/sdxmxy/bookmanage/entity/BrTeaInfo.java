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
@ApiModel(value="BrTeaInfo对象", description="")
public class BrTeaInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "借书证")
    @TableId
    private Long libCard;

    @ApiModelProperty(value = "图书编号")
    @TableId
    private String bookNum;

    @ApiModelProperty(value = "借书时间")
    @TableId
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date broTime;

    @ApiModelProperty(value = "归还期限")
    @TableId
    private Date rnDeadline;

    @ApiModelProperty(value = "归还时间")
    @TableId
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date rnTime;


}
