package com.nacos.web_user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nacos.web_user.dao.UserDao;
import com.nacos.web_user.feign.IOrderFeignService;
import com.nacos.web_user.model.po.User;
import com.nacos.web_user.service.IUserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wei
 * @since 2020-10-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Resource
    private IOrderFeignService orderFeignService;

    @Override
    @GlobalTransactional(name = "test",rollbackFor = Exception.class)
    public String hello() {
        User user = this.getById(1);
        this.updateById(user.setNum(user.getNum() + 1));
        return orderFeignService.hello();
    }
}
