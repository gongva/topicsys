/**
 * 
 */
package com.pzhu.topicsys.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pzhu.topicsys.common.util.DateUtil;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(getMappingJackson2HttpMessageConverter());
	}

	private MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(new MediaType("text", "plain"));
		supportedMediaTypes.add(new MediaType("application", "json"));
		messageConverter.setSupportedMediaTypes(supportedMediaTypes);
		return messageConverter;
	}

	@Bean
	public Converter<String, Date> dateConvert() {
		return new Converter<String, Date>() {
			@Override
			public Date convert(String source) {
				if (StringUtils.isBlank(source)) {
					return null;
				}
				return DateUtil.parseDate(source.trim());
			}
		};
	}
}
