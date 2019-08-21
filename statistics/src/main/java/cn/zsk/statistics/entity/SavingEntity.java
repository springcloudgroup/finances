package cn.zsk.statistics.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class SavingEntity {

	@NotNull
	private BigDecimal amount;

	@NotNull
	private CurrencyEnum currency;

	@NotNull
	private BigDecimal interest;

	@NotNull
	private Boolean deposit;

	@NotNull
	private Boolean capitalization;

}
