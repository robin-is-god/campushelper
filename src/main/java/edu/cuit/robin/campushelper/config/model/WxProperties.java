package edu.cuit.robin.campushelper.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:43 2019/5/8
 * @ Description : TODO
 */

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxProperties {
    @Value("${AppId}")
    private String appId;

    @Value("${AppSecret}")
    private String appSecret;
}
