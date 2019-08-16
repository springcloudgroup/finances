package cn.zsk.statistics.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 * @author:zsk
 * @CreateTime:2019-08-16 09:40
 */
@Data
public class ExchangeRatesContainer {
    private LocalDate date = LocalDate.now();

    private Currency base;

    private Map<String, BigDecimal> rates;
}
