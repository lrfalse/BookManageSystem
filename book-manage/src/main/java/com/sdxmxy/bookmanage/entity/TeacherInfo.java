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
@ApiModel(value="TeacherInfo对象", description="")
public class TeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "职工号")
    private String teaNum;

    @TableId
    @ApiModelProperty(value = "职工名")
    private String teaName;

    @TableId
    @ApiModelProperty(value = "职工所在学院")
    private String teaCollege;

    @TableId
    @ApiModelProperty(value="逻辑删除")
    @TableField(value = "tea_delete", fill = FieldFill.INSERT)
    @TableLogic
    private boolean teaDelete;
}
