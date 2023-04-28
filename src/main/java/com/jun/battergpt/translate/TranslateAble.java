package com.jun.battergpt.translate;

import com.jun.battergpt.translate.pojo.TranslateReq;
import com.jun.battergpt.translate.pojo.TranslateRes;

/**
 * @Author: HuangChengJun
 * @Date: 2023/4/27 17:04
 * @Description:
 */
public interface TranslateAble {
    TranslateRes translate(TranslateReq translateRequest);
}
