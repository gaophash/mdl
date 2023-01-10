package com.jiasu.mdl.entity;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.jiasu.mdl.enums.CodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Description : Response. <br />
 * Create Time : 2023年1月9日 <br />
 * Copyright : Copyright (c) 2010 - 2022 All rights reserved. <br />
 *
 * @author gaopeng
 * @version 1.0
 */
@ApiModel
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 4650258496699496610L;

    public static final int SUCCESS = 200;

    @ApiModelProperty(value = "响应报文的响应码，code==200即为正常响应")
    private int rsp_code;

    @ApiModelProperty(value = "响应报文的消息提示")
    private String rsp_msg;

    @ApiModelProperty(value = "响应报文的消息体")
    private T body;

    @ApiModelProperty(value = "响应报文的时间戳：标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS")
    private String timestamp;

    public Response(T body) {
        this(SUCCESS, "成功", body);
    }

    public Response(int rsp_code, String rsp_msg, T body) {
        this.rsp_code = rsp_code;
        this.rsp_msg = rsp_msg;
        this.body = body;
        timestamp = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_PATTERN);
    }

    public int getRsp_code() {
        return rsp_code;
    }

    public void setRsp_code(int rsp_code) {
        this.rsp_code = rsp_code;
    }

    public String getRsp_msg() {
        return rsp_msg;
    }

    public void setRsp_msg(String rsp_msg) {
        this.rsp_msg = rsp_msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T data) {
        this.body = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public static <T> Response<T> ok() {
        return ok(null);
    }

    public static <T> Response<T> ok(T body) {
        return new Response<T>(body);
    }

    public static Response<?> error(CodeEnum codeEnum) {
        return error(codeEnum.getCode(), codeEnum.getMessage());
    }

    public static Response<Object> error(int code, String message) {
        return new Response<Object>(code, message, null);
    }

    @Override
    public String toString() {
        return "Response [rsp_code=" + rsp_code + ", rsp_msg=" + rsp_msg + ", body=" + body + "]";
    }
}