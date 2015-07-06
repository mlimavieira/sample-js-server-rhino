package com.mobicare.sample.js;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mobicare.sample.js.service.ServiceSample;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	private ScriptEngineManager manager;
	private ScriptEngine engine;

	@Autowired
	private ServiceSample serviceSample;

	@PostConstruct
	public void beforeTest() throws FileNotFoundException, ScriptException {
		final InputStream in = this.getClass().getResourceAsStream("/sample.js");
		final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");

		engine.eval(reader);
		engine.put("serviceSample", serviceSample);
	}

	@Test
	public void testExecuteJsWithOutSpringSevice() throws ScriptException, NoSuchMethodException {
		final Invocable inv = (Invocable) engine;
		inv.invokeFunction("hello", "Scripting!!");
	}

	@Test
	public void testWithBeanExecution() throws ScriptException, NoSuchMethodException {
		final Invocable inv = (Invocable) engine;
		inv.invokeFunction("executeCallback");
	}

	@Test
	public void testWithUseSampleDto() throws ScriptException, NoSuchMethodException {
		final Invocable inv = (Invocable) engine;
		inv.invokeFunction("printSampleDto", serviceSample.getSampleDto());
	}

}
