package com.sdxmxy.bookmanage.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="StuInfo对象", description="")
public class StuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "学号")
    private String stuNum;

    @TableId
    @ApiModelProperty(value = "姓名")
    private String stuName;

    @TableId
    @ApiModelProperty(value = "学院")
    private String stuCollege;

    @TableId
    @ApiModelProperty(value = "年级")
    private Integer stuGrade;

    @TableId
    @ApiModelProperty(value="逻辑删除")
    @TableField(value = "DELETED", fill = FieldFill.INSERT)
    @TableLogic
    private boolean stuDelete;

    @TableId
    @ApiModelProperty(value="已借数量")
    private String stuBrnum;


}
