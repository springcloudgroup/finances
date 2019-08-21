package cn.zsk.notification.mapper.converter;


import cn.zsk.notification.entity.FrequencyEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FrequencyReaderConverter implements Converter<Integer, FrequencyEnum> {

	@Override
	public FrequencyEnum convert(Integer days) {
		return FrequencyEnum.withDays(days);
	}
}
