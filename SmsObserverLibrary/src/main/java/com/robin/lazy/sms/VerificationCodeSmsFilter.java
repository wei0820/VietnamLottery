/*
 * 文 件 名:  CerificationCode.java
 * 版    权:  Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  江钰锋 00501
 * 修改时间:  16/6/2
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */

package com.robin.lazy.sms;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 短信验证码过滤器
 *
 * @author 江钰锋 00501
 * @version [版本号, 16/6/2]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class VerificationCodeSmsFilter implements SmsFilter {
    /**
     * 需要过滤的发短信的人
     */
    private String filterAddress;

    public VerificationCodeSmsFilter(String filterAddress) {
        this.filterAddress = filterAddress;
    }

    @Override
    public String filter(String address, String smsContent) {
        if (address.startsWith(filterAddress)) {
            if(!smsContent.equals("")) {
                return smsContent;
            }
        }

        Log.i("[SMS]", "filter return null !!");
        return null;
    }
}
