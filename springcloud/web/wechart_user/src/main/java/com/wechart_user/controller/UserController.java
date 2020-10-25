package com.wechart_user.controller;


import com.model.vo.TestValidVo;
import com.model.po.User;
import com.model.valid.Post;
import com.util.LnUtils;
import com.wechart_user.feginservice.IFeignService;
import com.wechart_user.service.IUserService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wei
 * @since 2020-10-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Resource
    private IFeignService feignService;

    @GetMapping("{id}")
    public String getUserNameById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user != null) {
            return user.getUserName();
        }
        return "无此用户id:" + id;
    }

    @GetMapping("ribbon")
    public String hello() {
        return feignService.hello();
    }

    @GetMapping("testId")
    public String getParam() {
        return feignService.getParam(String.valueOf(LnUtils.getRandom(0, 10)));
    }

    @PostMapping
    public String testVo(@RequestBody @Validated({Post.class}) TestValidVo testValidVo,
                         BindingResult bindingResult){
        System.out.println(testValidVo.toString());
        if (bindingResult.hasErrors()) {
            return "fal";
        }
        return "suc";
    }
}
