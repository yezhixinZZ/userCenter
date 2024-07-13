package com.yzx.usercenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置CORS(Cross-Origin Resource Sharing)策略。
     * 该方法重写了WebMvcConfigurer接口的addCorsMappings方法，用于设置跨域资源共享规则。
     * 跨域资源共享是一种机制，允许Web端的应用程序访问不属于本域的资源。
     *
     * @param registry CORS配置注册表，通过该注册表可以添加和配置CORS映射。
     *                 这里使用了Spring MVC提供的CorsRegistry来添加CORS配置。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加一个映射，匹配所有请求路径
        registry.addMapping("/**")
                // 允许所有来源访问，"*"表示不限制域名
                .allowedOrigins("*")
                // 允许所有HTTP方法访问
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许客户端在请求中包含凭证（如cookies）
                .allowCredentials(true)
                // 设置预检请求（OPTIONS请求）的缓存时间，单位为秒
                .maxAge(3600)
                // 允许所有请求头
                .allowedHeaders("*");
    }

}
