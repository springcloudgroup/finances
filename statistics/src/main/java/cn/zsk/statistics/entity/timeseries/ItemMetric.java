package cn.zsk.statistics.entity.timeseries;



import cn.zsk.statistics.entity.CurrencyEnum;
import cn.zsk.statistics.entity.ItemEntity;
import cn.zsk.statistics.entity.TimePeriodEnum;

import java.math.BigDecimal;

/**
 * Represents normalized {@link ItemEntity} object
 * with {@link CurrencyEnum#getBase()} currency and {@link TimePeriodEnum#getBase()} time period
 */
public class ItemMetric {

	private String title;

	private BigDecimal amount;

	public ItemMetric(String title, BigDecimal amount) {
		this.title = title;
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ItemMetric that = (ItemMetric) o;

		return title.equalsIgnoreCase(that.title);

	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}
}
