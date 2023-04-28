package com.jun.battergpt.translate;

import com.jun.battergpt.common.ResponseData;
import com.jun.battergpt.translate.pojo.TranslateReq;
import com.jun.battergpt.translate.pojo.TranslateRes;
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
    private TranslateService translateService;


    @PostMapping("/translate")
    public ResponseData<String> translate(@RequestBody TranslateReq translateRequest) {
        TranslateRes res = translateService.translate(translateRequest);
        return ResponseData.success(res.getTargetText());
    }
}
