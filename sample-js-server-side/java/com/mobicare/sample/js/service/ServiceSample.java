package com.mobicare.sample.js.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import com.mobicare.sample.js.dto.SampleDto;

@Component
public class ServiceSample {

	public String getRandomValue() {
		return RandomStringUtils.randomAlphabetic(6);
	}

	public String getRandomValue(String arg) {
		return arg + " - " + getRandomValue();
	}

	public SampleDto getSampleDto() {
		return new SampleDto(RandomUtils.nextLong(1, 200000), RandomStringUtils.randomAlphabetic(8));
	}

}
