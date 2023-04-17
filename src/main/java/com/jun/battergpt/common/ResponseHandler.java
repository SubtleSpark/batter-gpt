package com.jun.battergpt.common;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: HuangChengJun
 * @Date: 2023/4/17 16:50
 * @Description:
 */
@RestControllerAdvice
@Slf4j
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(final @NotNull MethodParameter returnType,
                            final @NotNull Class converterType) {
        // 这个方法返回 true 时，beforeBodyWrite 才会执行
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @NotNull MethodParameter returnType,
                                  @NotNull MediaType selectedContentType,
                                  @NotNull Class selectedConverterType,
                                  @NotNull ServerHttpRequest request,
                                  @NotNull ServerHttpResponse response) {
        if (body == null) {
            ResponseData<Object> responseData = new ResponseData<>();
            responseData.setStatus("Success");
            responseData.setMessage("");
            return responseData;
        } else if (body instanceof ResponseData) {
            return body;
        } else {
            ResponseData<Object> responseData = new ResponseData<>();
            responseData.setStatus("Success");
            responseData.setMessage("");
            responseData.setData(body);
            return responseData;
        }
    }
}
