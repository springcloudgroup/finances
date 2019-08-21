package cn.zsk.notification.entity;

import java.util.stream.Stream;

public enum FrequencyEnum {

	WEEKLY(7), MONTHLY(30), QUARTERLY(90);

	private int days;

	FrequencyEnum(int days) {
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	public static FrequencyEnum withDays(int days) {
		return Stream.of(FrequencyEnum.values())
				.filter(f -> f.getDays() == days)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
