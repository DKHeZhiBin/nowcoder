package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Test
    public void testSendEmail(){
        mailClient.sendMail("820904682@qq.com","test","好绝望");
    }

//    spring自带的模板引擎对象
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("lihonghe@nowcoder.com", "HTML", content);
    }
}
