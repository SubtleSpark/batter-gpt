package com.jun.battergpt.common;

import lombok.Data;

/**
 * @Author: HuangChengJun
 * @Date: 2023/4/17 16:52
 * @Description:
 */
@Data
public class ResponseData<T> {
    private String status;
    private String message;
    private T data;

    public ResponseData() {
    }

    public static <T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setStatus("Success");
        responseData.setMessage("");
        responseData.data = data;
        return responseData;
    }
}