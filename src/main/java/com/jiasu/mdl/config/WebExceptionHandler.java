package com.jiasu.mdl.config;

import com.jiasu.mdl.enums.ErrorCodeEnum;
import com.jiasu.mdl.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * SpringMVC统一异常处理
 *
 * @author gaopeng
 * @date 2020-09-07
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {

    /**
     * 捕获Validation的异常信息
     *
     * @param e
     * @return CommonResult
     */
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Response<?> validException(Exception e) {
        StringBuffer errorMessage = new StringBuffer();
        BindingResult bindingResult;
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage())
                        .append(", ");
            }
        } else if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage())
                        .append(", ");
            }
        } else {
            errorMessage.append("Validation 参数处理异常");
            return new Response<>(ErrorCodeEnum.CODE_9992.getCode(), errorMessage.toString(), null);
        }
        log.warn(ErrorCodeEnum.CODE_9992.getMessage() + ": {}", errorMessage.toString());
        return new Response<>(ErrorCodeEnum.CODE_9992.getCode(), errorMessage.toString(), null);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Response<?> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.warn(ErrorCodeEnum.CODE_9997.getMessage() + ": {}", e.getMessage());
        return new Response<>(ErrorCodeEnum.CODE_9997.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response<?> constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        StringBuffer errorMessage = new StringBuffer();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<?> obj = iterator.next();
            errorMessage.append(obj.getMessage()).append(", ");
        }
        log.warn(ErrorCodeEnum.CODE_9992.getMessage() + ": {}", errorMessage.toString());
        return new Response<>(ErrorCodeEnum.CODE_9992.getCode(), errorMessage.toString(), null);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Response<?> noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        log.warn("请求路径不存在", e);
        return Response.error(ErrorCodeEnum.CODE_9998);
    }

    @ExceptionHandler(value = Exception.class)
    public Response<?> unknownException(Exception e) {
        log.error("服务器未知异常", e);
        return Response.error(ErrorCodeEnum.CODE_9999);
    }


}
