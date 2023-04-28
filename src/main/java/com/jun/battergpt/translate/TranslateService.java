package com.jun.battergpt.translate;

import com.jun.battergpt.translate.pojo.TranslateReq;
import com.jun.battergpt.translate.pojo.TranslateRes;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: HuangChengJun
 * @Date: 2023/4/23 9:04
 * @Description: 代理各种翻译组件
 */
@Service
public class TranslateService implements TranslateAble {
    @Autowired
    private List<TranslateAble> transList;

    @PostConstruct
    private void init() {
        // 删除类型和自己一样的 bean
        transList.removeIf(next -> next.getClass().equals(this.getClass()));
    }

    @Override
    public TranslateRes translate(TranslateReq translateRequest) {
        TranslateAble translateAble = selectTranslator(transList);
        return translateAble.translate(translateRequest);
    }

    private TranslateAble selectTranslator(List<TranslateAble> transList) {
        if (transList.size() == 0) {
            throw new RuntimeException("没有可用的翻译组件");
        }
        return transList.get(0);
    }
}
