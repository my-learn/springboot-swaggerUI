package edu.maskleo.swaggerui.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户")
public class User {

    @ApiModelProperty(name = "主键", required = true)
    private int id;

    @ApiModelProperty(name = "用户名", required = true)
    private String username;

    @ApiModelProperty(name = "年龄", required = true)
    private int age;

}
