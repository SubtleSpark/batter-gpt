package com.jun.battergpt.translate;

import com.aliyun.alimt20181012.Client;
import com.aliyun.alimt20181012.models.TranslateGeneralRequest;
import com.aliyun.alimt20181012.models.TranslateGeneralResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import com.jun.battergpt.common.ResponseData;
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
    public RuntimeOptions runtime = new RuntimeOptions();


    @PostMapping("/translate")
    public ResponseData<String> translate(@RequestBody TranslateGeneralRequest translateRequest) throws Exception {
        if (translateRequest.getFormatType() == null) {
            translateRequest.setFormatType("text");
        }
        TranslateGeneralResponse translate = aliApiClient.translateGeneralWithOptions(translateRequest, runtime);
        return ResponseData.success(translate.getBody().getData().getTranslated());
    }

}
