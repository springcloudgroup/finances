package cn.zsk.account.client;

import cn.zsk.account.entity.AccountEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author:zsk
 * @CreateTime:2019-08-15 16:48
 */
@Component
public class StatisticsServiceClientFallback implements StatisticsServiceClient{
    private static final Logger logger = LoggerFactory.getLogger(StatisticsServiceClientFallback.class);

    @Override
    public void updateStatistics(String accountName, AccountEntity account) {
        logger.error("Error during update statistics for account: {}", accountName);
    }
}
