package com.yixuexi.springcloud.controller;

import com.yixuexi.springcloud.entities.CommonResult;
import com.yixuexi.springcloud.entities.Payment;
import com.yixuexi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @date: 2021/4/5   1:25
 * @author: 易学习
 */
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 注入端口号
     */
    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @PostMapping("/create/payment")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info(payment.toString());

        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult<Payment>(200, "创建成功");
        } else{
            return new CommonResult<Payment>(444,"创建失败");
        }

    }
    @GetMapping("/get/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);

        if (paymentById != null){
            return new CommonResult<Payment>(200,"查询成功 "+ port,paymentById);
        }else{
            return new CommonResult<Payment>(444,"未查询到");
        }

    }

    @RequestMapping("/get/lb")
    public String getLBid(){
        return port;
    }

    @RequestMapping("/get/feign/time/out")
    public String timeOut() throws InterruptedException {
        Thread.sleep(3000);

        return port;
    }
}
