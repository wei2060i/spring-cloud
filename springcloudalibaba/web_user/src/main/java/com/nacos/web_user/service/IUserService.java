package com.nacos.web_user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nacos.web_user.model.po.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wei
 * @since 2020-10-23
 */
public interface IUserService extends IService<User> {

    String hello();

}
