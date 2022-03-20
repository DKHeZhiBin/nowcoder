package com.nowcoder.community;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)

//LoggerTest是待测试的类名，一般一个类一个logger
public class LoggerTest {
    private  static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());
//       常用 debug info error
        logger.trace("trace logger");
        logger.debug("debug logger");
        logger.info("info logger");
        logger.warn("warn logger");
        logger.error("error logger");
    }
}
