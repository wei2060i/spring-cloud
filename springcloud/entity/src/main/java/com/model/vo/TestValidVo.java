package com.model.vo;

import com.model.valid.Post;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class TestValidVo {

    @NotNull(groups = {Post.class}, message = "name不能是控股")
    private String name;

    private Integer age;
}
