/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context;

import java.io.Closeable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ProtocolResolver;

public interface ConfigurableApplicationContext extends ApplicationContext, Lifecycle, Closeable {

	String CONFIG_LOCATION_DELIMITERS = ",; \t\n";

	String CONVERSION_SERVICE_BEAN_NAME = "conversionService";

	String LOAD_TIME_WEAVER_BEAN_NAME = "loadTimeWeaver";

	String ENVIRONMENT_BEAN_NAME = "environment";

	String SYSTEM_PROPERTIES_BEAN_NAME = "systemProperties";

	String SYSTEM_ENVIRONMENT_BEAN_NAME = "systemEnvironment";

	void setId(String id);

	void setParent(ApplicationContext parent);

	void setEnvironment(ConfigurableEnvironment environment);

	@Override
	ConfigurableEnvironment getEnvironment();

	void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

	void addApplicationListener(ApplicationListener<?> listener);

	void addProtocolResolver(ProtocolResolver resolver);

	void refresh() throws BeansException, IllegalStateException;

	void registerShutdownHook();

	@Override
	void close();

	boolean isActive();

	ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;

}
