package com.example.swagger.controller;

import com.example.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 戴志豪
 * @date 2021/10/8 18:40
 */
@RestController
@RequestMapping("//Hello")
@Api(tags = "测试控制器")
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "{'text':'hello'}";
    }

    @PostMapping("/Test")
    public String test(){
        return "{'text':'hello'}";
    }

    @GetMapping("/User")
    public User user(){
        return new User("llll","123456");
    }

    @ApiOperation("测试Post传参")
    @PostMapping("/User2")
    public User user(@RequestBody User user){
        return user;
    }

    /**
     * @Api：用在请求的类上，表示对类的说明
     *     tags="说明该类的作用，UI界面显示"
     *     value="UI界面不显示，无用"
     *
     * @ApiOperation：用在请求的接口上，解释说明
     *     value="对接口的说明"
     *     notes="接口的描述"
     *
     * @ApiImplicitParams：用在请求的接口上，表示一组参数说明
     *     @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     *         name：参数名
     *         value：参数的汉字说明、解释
     *         required：参数是否必须传
     *         paramType：参数放在哪个地方
     *             · header --> 请求参数的获取：@RequestHeader
     *             · query --> 请求参数的获取：@RequestParam
     *             · path（用于restful接口）--> 请求参数的获取：@PathVariable
     *             · body（不常用）
     *             · form（不常用）
     *         dataType：参数类型，默认String，其它值dataType="int"
     *         defaultValue：参数的默认值
     *
     * @ApiResponses：用在请求的方法上，表示一组响应
     *     @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
     *         code：数字，例如400
     *         message：信息，例如"请求参数没填好"
     *         response：抛出异常的类
     *
     * @ApiModel：用于响应类上，表示一个返回响应数据的信息
     *     @ApiModelProperty：用在属性上，描述响应类的属性
     */
}
