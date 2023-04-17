package com.jun.battergpt.translate;

import com.aliyun.alimt20181012.Client;
import com.aliyun.alimt20181012.models.TranslateGeneralRequest;
import com.aliyun.alimt20181012.models.TranslateGeneralResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuangChengJun
 * @date 2023/4/16 22:29
 */
@RestController
@Slf4j
public class TranslateController {

    @Autowired
    public Client aliApiClient;


    @PostMapping("/translate")
    public String translate(@RequestBody TranslateGeneralRequest translateRequest) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        TranslateGeneralResponse translate = aliApiClient.translateGeneralWithOptions(translateRequest, runtime);
        return translate.getBody().getData().getTranslated();
    }

}
