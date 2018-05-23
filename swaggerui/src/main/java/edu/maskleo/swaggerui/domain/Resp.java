package edu.maskleo.swaggerui.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("结果")
public class Resp<T> {

    @ApiModelProperty("数据")
    private T t;

    @ApiModelProperty("状态")
    private int status;

    public Resp() {

    }

    private static Resp build() {
        Resp resp = new Resp();
        return resp;
    }

    public static <T> Resp<T> ok(T t) {
        return build().setStatus(200).setT(t);
    }

    public T getT() {
        return t;
    }

    public Resp<T> setT(T t) {
        this.t = t;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Resp setStatus(int status) {
        this.status = status;
        return this;
    }
}
