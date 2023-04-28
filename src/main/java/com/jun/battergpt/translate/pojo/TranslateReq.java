package com.jun.battergpt.translate.pojo;


import lombok.Data;

/**
 * @Author: HuangChengJun
 * @Date: 2023/4/27 16:53
 * @Description: 统一翻译请求
 */
@Data
public class TranslateReq {
    public String sourceLanguage;
    public String sourceText;
    public String targetLanguage;

    // region ali参数
    public String context;
    public String formatType;
    public String scene;
    // endregion
}
