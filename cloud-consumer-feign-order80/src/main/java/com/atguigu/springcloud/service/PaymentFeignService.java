package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * @Param
     * 代码示例：
     * @Select("select * from user where uid = #{uid} and uname = #{uname}")
     * List<User> getUserList(@Param("uid") Integer id, @Param("uname") String name);
     * 特点：
     * @Param主要应用在Dao层
     * 注解中的sql语句有多个条件参数，且和方法中的参数名称不一致，此时可以使用@Param注解
     * 只有一个参数时，可以不使用注解（不过还是建议使用= =）
     * 参数的顺序无关
     *
     * @RequestParam
     * 代码示例：
     * @ResponseBody
     * @RequestMapping(value = "/user/get", method = RequestMethod.POST)
     * public List<User> getUserList(@RequestParam("uid") Integer id, @RequestParam("uname") String name) {
     * }
     * 特点：
     * @RequestParam主要应用在Controller层
     * 前端提交的form表单数据中的属性名和方法中的参数名不一致时 ，springMVC就无法自动封装参数，所以需要 @RequestParam（"前端所传属性名"） 来指定前端提交的表单的属性的名称
     * 前端提交的form表单数据中的属性名和方法中的参数名一致时，可以不使用此注解
     *
     * @PathVariable
     * 代码示例：
     * @ResponseBody
     * @RequestMapping("/user/{uid}")
     * public User getUserById(@PathVariable("uid") Long uid) {
     * }
     * // 请求路径：http://localhost:8080/user/12001
     * 特点：
     * 应用在Controller层
     * @PathVariable是spring3.0的一个新功能：可接收请求路径中占位符的值，通过 @PathVariable 可以将URL中占位符参数{uid}绑定到处理器类的方法形参uid中 —— @PathVariable(“uid“)
     * 请求路径中占位符的名字可与方法参数名不一样：public User getUserById(@PathVariable(“uid”) Long id)
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(("id")) Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
