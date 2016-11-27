package com.weikun.service;

import com.weikun.mapper.AccountMapper;
import com.weikun.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/27.
 */
@Service
public class UserService {
    @Autowired
    private AccountMapper mapper;
    public Account login(@Param("account") Account account){

        return mapper.login(account.getUsername(),account.getPassword());
    }
}
