package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;
import java.util.ArrayList;

/**
 * @Author 戴志豪
 * @date 2021/10/8 18:08
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    Contact DEFAULT_CONTACT = new Contact("", "", "");


    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket docket(Environment environment) {

        // 获取生产环境配置文件类型
        Profiles profile = Profiles.of("dev", "test");

        // 监听生产环境配置文件是否是上面定义的，若不是，则返回false
        boolean flag = environment.acceptsProfiles(profile);

        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("lll")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                /**
                 * RequestHandlerSelectors 配置要扫描接口的方式
                 *                  basePackage：指定要扫描的包（常用）
                 *                  any（）:扫描全部
                 *                  none（）:不扫描
                 *                  withMethodAnnotation: 扫描方法上有指定注解的接口
                 *                  withClassAnnotation: 扫描类上有指定注解的类的所有接口
                 */
                .apis(RequestHandlerSelectors.any())

                .paths(PathSelectors.ant("//Hello"))
                .build();
    }


    /**
     * Swagger配置信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "猫儿的Swagger",
                "Api Documentation",
                "v1.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}
