package com.newroad.controller;


import com.newroad.entity.User;
import com.newroad.result.ResultMsg;
import com.newroad.service.UserServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
public class UserController {
    @Autowired
    private UserServiceIf userService;

    @RequestMapping("user")



    public List<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * 注册提交:1.注册验证 2 发送邮件 3验证失败重定向到注册页面
     * 注册页获取:根据account对象为依据判断是否注册页获取请求
     *
     * @param account
     * @param modelMap
     * @return
     */
    @RequestMapping("accounts/register")
    public String accountsRegister(ModelMap modelMap,User account){
        ResultMsg resultMsg = UserHelper.validate(account);
        if (account==null ||account.getName()==null) {
            return "/user/accounts/register";
        }else {
            return "redirect:/accounts/register?" + resultMsg.asUrlParams();
        }
    }


}
