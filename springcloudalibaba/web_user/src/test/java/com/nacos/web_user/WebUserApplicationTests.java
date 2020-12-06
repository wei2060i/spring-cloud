package com.nacos.web_user;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebUserApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(IdWorker.getId());
    }

}
