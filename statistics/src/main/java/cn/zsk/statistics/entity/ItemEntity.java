package cn.zsk.statistics.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ItemEntity {

	@NotNull
	@Length(min = 1, max = 20)
	private String title;

	@NotNull
	private BigDecimal amount;

	@NotNull
	private CurrencyEnum currency;

	@NotNull
	private TimePeriodEnum period;

}
