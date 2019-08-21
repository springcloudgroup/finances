package cn.zsk.notification.mapper.converter;


import cn.zsk.notification.entity.FrequencyEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FrequencyWriterConverter implements Converter<FrequencyEnum, Integer> {

	@Override
	public Integer convert(FrequencyEnum frequency) {
		return frequency.getDays();
	}
}
