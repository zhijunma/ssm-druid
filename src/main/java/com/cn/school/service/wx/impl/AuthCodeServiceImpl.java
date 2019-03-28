package com.cn.school.service.wx.impl;

import com.cn.school.service.wx.AuthCodeService;
import com.cn.school.utils.pay.ApiMotest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Service;

/**
 * @Author: leiyunlong
 * @Date: 2019/3/26 19:05
 * @Version 1.0
 */
@Service
@Slf4j
public class AuthCodeServiceImpl  implements AuthCodeService {
    @Override
    public String rollback(String code, String state) {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        String secret = "b5f3b0b6108dc344d924d4b5f24c796c";
        String APPID = "wx7a643cf968956196";
        String reqUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        String get = ApiMotest.sendPost(reqUrl, "GET");
        return get;
    }
}