package com.sdxmxy.bookmanage.entity;

import java.util.Date;
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
@ApiModel(value="BookInfo对象", description="")
public class BookInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value = "图书编号")
    private String bookNum;

    @TableId
    @ApiModelProperty(value = "图书名")
    private String bookName;

    @TableId
    @ApiModelProperty(value = "图书分类")
    private String bookCla;

    @TableId
    @ApiModelProperty(value = "图书出版社")
    private String bookPre;

    @ApiModelProperty(value = "图书总数目")
    private Integer bookAllQuan;

    @ApiModelProperty(value = "可借数目")
    private Integer bookQuan;

    @ApiModelProperty(value = "出版时间")
    private Date bookTime;


}
