package org.study.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * 例子
 * Created by LiZW on 2016/12/27.
 */
public class LogTest {
    private static final Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.info("测试日志！");

        logger.debug("Logging in user {} with birthday {}", "李志伟", new Date());

        logger.debug("Logging in user %s with birthday %s", "李志伟", new Date());
        logger.debug("Logging in user %1$s with birthday %2$tm %2$te,%2$tY", "李志伟", new Date());
        logger.debug("Integer.MAX_VALUE = %,d", Integer.MAX_VALUE);
        logger.debug("Long.MAX_VALUE = %,d", Long.MAX_VALUE);
    }
}
