package com.wechart_user.service.impl;

import com.model.po.User;
import com.wechart_user.dao.UserDao;
import com.wechart_user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
