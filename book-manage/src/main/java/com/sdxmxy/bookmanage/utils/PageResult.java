package com.sdxmxy.bookmanage.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@ApiModel(value="分页返回结果")
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {

    @ApiModelProperty(value="总记录条数")
    private Long total;

    @ApiModelProperty(value="返回的条数")
    private List<T> rows;


}
