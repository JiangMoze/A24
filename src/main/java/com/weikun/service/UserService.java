package com.weikun.service;

import com.weikun.mapper.AccountMapper;
import com.weikun.mapper.ProfileMapper;
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
    private AccountMapper amapper;


    @Autowired
    private ProfileMapper pmapper;


    public boolean  save(@Param("account") Account account
                       ){
        //先存account,在存profile
        //防止profile类没设置username字段
        account.getProfile().setUsername(account.getUsername());
        return (amapper.insert(account)>0&&pmapper.insert(account.getProfile())>0);
    }

    public Account login(@Param("account") Account account){

        return amapper.login(account.getUsername(),account.getPassword());
    }
}
