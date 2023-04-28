package com.jun.battergpt.translate.configuration;

import com.aliyun.alimt20181012.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuangChengJun
 * @date 2023/4/16 20:56
 */
@Configuration
@ConfigurationProperties(prefix = "ali.translate")
@ConditionalOnProperty(prefix = "ali.translate", name = "access-key-id")
public class AliTranslateAutoConfiguration {
    private String accessKeyId;
    private String accessKeySecret;

    @Bean
    public Client aliApiClient() throws Exception {
        Config config = new Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(getAccessKeyId())
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(getAccessKeySecret());
        // 访问的域名
        config.endpoint = "mt.cn-hangzhou.aliyuncs.com";
        return new Client(config);
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

}
