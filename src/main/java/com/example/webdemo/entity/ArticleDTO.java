package com.example.webdemo.entity;


import com.example.webdemo.zhujie.EnumValues;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ArticleDTO {

    @NotNull(message = "文章id不能为空",groups = UpdateArticleDTO.class)
    @Min(value = 1,message = "文章id不能小于1")
    private Integer id;

    @NotBlank(message = "文章内容不能为空",groups = {AddArticleDTO.class,UpdateArticleDTO.class})
    private String content;

    @NotBlank(message = "不为空",groups = AddArticleDTO.class)
    private String authorId;

    @Future(message = "时间不能为过去",groups = {AddArticleDTO.class,UpdateArticleDTO.class})
    private Date submitTime;


    //修改文章的分组
    public interface UpdateArticleDTO{}

    //添加文章的分组
    public interface AddArticleDTO{}

    @EnumValues(values = {1,2},message = "性别只能传入1或者2")
    private Integer gender;




}
