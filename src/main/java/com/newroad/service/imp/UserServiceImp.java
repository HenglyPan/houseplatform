package com.newroad.service.imp;

import com.google.common.collect.Lists;
import com.newroad.dao.UserMapper;
import com.newroad.entity.User;
import com.newroad.service.FileService;
import com.newroad.service.UserServiceIf;
import com.newroad.util.BeanHelper;
import com.newroad.util.HashUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserServiceIf{
    @Resource
    private UserMapper userMapper;
    @Resource
    private FileService fileService;
    public List<User> getUsers(){
        return userMapper.selectUsers();
    }
    /**
     * 1.插入数据库，非激活;密码加盐md5;保存头像文件到本地
     * 2.生成key，绑定email
     * 3.发送邮件给用户
     *
     * @param account
     * @return
     */
    @Override
    public boolean addAccount(User account) {
      account.setPasswd(HashUtils.encryPassword(account.getPasswd()));
        List<String> imgList = fileService.getImgPaths(Lists.newArrayList(account.getAvatarFile()));
        if (!imgList.isEmpty()){
            account.setAvatar(imgList.get(0));
        }
        BeanHelper.setDefaultProp(account,User.class);
        BeanHelper.onInsert(account);
        account.setEnable(0);
        userMapper.insert(account);
         registerNotify(account.getEmail());

        return true;
    }

    private void registerNotify(String email) {

    }
}
