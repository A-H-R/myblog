package com.mouse.service.util;
/*
 *created by mouse on 2020/2/21
 */

public interface EmailService {
    /**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String to, String subject, String content);

}
