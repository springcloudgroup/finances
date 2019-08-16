package cn.zsk.notification.mapper.converter;


import cn.zsk.notification.entity.Frequency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FrequencyReaderConverter implements Converter<Integer, Frequency> {

	@Override
	public Frequency convert(Integer days) {
		return Frequency.withDays(days);
	}
}
