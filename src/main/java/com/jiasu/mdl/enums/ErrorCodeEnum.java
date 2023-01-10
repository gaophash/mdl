package com.jiasu.mdl.enums;

import lombok.AllArgsConstructor;

/**
 * @FileName : ErrorCodeEnum
 * @Version : 1.0
 * @Description :
 * @Author : gaopeng
 * @CreateDate : 2020/09/21 10:20
 */
@AllArgsConstructor
public enum ErrorCodeEnum implements CodeEnum {


    // 业务级
    CODE_1502000(502000, "账号不存在, 请联系运营人员"),
    CODE_1502001(502001, "账号已停用"),
    CODE_1502007(1502007, "原密码有误"),
    CODE_1502008(1502008, "两次输入的密码不一致"),
    CODE_1503001(1503001, "登录失败"),
    // 系统级
    CODE_9992(9992, "请求参数不符合规范"),
    CODE_9997(9997, "请求参数不完整"),
    CODE_9998(9998, "非法请求"),
    CODE_9999(9999, "系统错误"),

    ;


    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
