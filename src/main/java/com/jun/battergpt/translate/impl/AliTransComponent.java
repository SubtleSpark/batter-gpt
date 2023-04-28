package com.jun.battergpt.translate.impl;

import com.aliyun.alimt20181012.Client;
import com.aliyun.alimt20181012.models.TranslateGeneralRequest;
import com.aliyun.alimt20181012.models.TranslateGeneralResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import com.jun.battergpt.translate.TranslateAble;
import com.jun.battergpt.translate.pojo.TranslateReq;
import com.jun.battergpt.translate.pojo.TranslateRes;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: HuangChengJun
 * @Date: 2023/4/27 17:03
 * @Description:
 */
@Component
public class AliTransComponent implements TranslateAble {
    private final RuntimeOptions runtime = new RuntimeOptions();
    @Autowired
    private Client client;

    @Override
    @SneakyThrows
    public TranslateRes translate(TranslateReq req) {
        // 准备参数
        TranslateGeneralRequest aliTransReq = new TranslateGeneralRequest();
        aliTransReq.setContext(req.getContext());
        aliTransReq.setFormatType(req.getFormatType());
        aliTransReq.setScene(req.getScene());
        aliTransReq.setSourceLanguage(req.getSourceLanguage());
        aliTransReq.setSourceText(req.getSourceText());
        aliTransReq.setTargetLanguage(req.getTargetLanguage());

        if (aliTransReq.getFormatType() == null) {
            aliTransReq.setFormatType("html");
        }

        // 调用接口
        TranslateGeneralResponse translate = client.translateGeneralWithOptions(aliTransReq, runtime);

        // 包装返回
        TranslateRes translateRes = new TranslateRes();
        String transText = translate.getBody().getData().getTranslated();
        translateRes.setTargetText(transText);
        return translateRes;
    }
}
