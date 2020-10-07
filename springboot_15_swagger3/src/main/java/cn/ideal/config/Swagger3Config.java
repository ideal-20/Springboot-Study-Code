package cn.ideal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @ClassName: SwaggerConfig
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/10/7 11:22
 * @Version: 1.0
 */

@Configuration
public class Swagger3Config {
    @Bean
    public Docket createRestApi(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // 通过 enable() 接收决定是否要显示
                .enable(flag)
                // 通过.select()方法，去配置扫描接口
                .select()
                // RequestHandlerSelectors 配置扫描接口的具体方式
                .apis(RequestHandlerSelectors.basePackage("cn.ideal.controller"))
                .paths(PathSelectors.ant("/test/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("BWH_Steven", "https://www.ideal-20.cn", "ideal_bwh@163.com");
        return new ApiInfo(
                "Swagger3学习——理想二旬不止", // 标题
                "学习演示如何配置Swagger2", // 描述
                "v1.0", // 版本
                "https://www.ideal-20.cn", // 组织链接
                contact, // 联系人信息
                "Apache 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
