package org.prcode.aspect;

import org.prcode.basedomain.log.commLogger.dao.CommLoggerMapper;
import org.prcode.basedomain.log.commLogger.domain.CommLogger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: LoggerRecordService
 * @Date: 2017-03-30 16:00
 * @Auther: kangduo
 * @Description: ()
 */
@Service
public class LoggerRecordService {
    @Resource
    private CommLoggerMapper commLoggerMapper;

    /**
     * 异步记录日志，避免日志记录中报错，或者记录过慢
     * 异步方法在同一个类内调用，不会异步的
     * @param commLogger 日志
     */
    @Async
    void doRecord(CommLogger commLogger) {
        commLoggerMapper.insert(commLogger);
    }
}
