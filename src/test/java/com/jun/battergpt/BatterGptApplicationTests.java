package com.jun.battergpt;

import com.aliyun.alimt20181012.Client;
import com.aliyun.alimt20181012.models.TranslateGeneralRequest;
import com.aliyun.alimt20181012.models.TranslateGeneralResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatterGptApplicationTests {
    @Autowired
    public Client aliApiClient;

    @Test
    void contextLoads() throws Exception {
        TranslateGeneralRequest translateRequest = new TranslateGeneralRequest();
        translateRequest.setSourceLanguage("auto");
        translateRequest.setTargetLanguage("zh");
        translateRequest.setFormatType("text");
        translateRequest.setSourceText("hello world");
        RuntimeOptions runtime = new RuntimeOptions();

        TranslateGeneralResponse translate = aliApiClient.translateGeneralWithOptions(translateRequest, runtime);
        System.out.println(translate);
        System.out.println(translate.getBody().getData().getTranslated());
    }

}
