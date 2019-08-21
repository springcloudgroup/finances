package cn.zsk.statistics.entity;

public enum CurrencyEnum {

	USD, EUR, RUB;

	public static CurrencyEnum getBase() {
		return USD;
	}
}
