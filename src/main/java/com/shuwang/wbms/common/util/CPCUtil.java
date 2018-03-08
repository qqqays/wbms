package com.shuwang.wbms.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Customized Property Configurer Util abbr to cpc for getting configure from properties files.
 *
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-06-2018 11:44
 */
public class CPCUtil extends PropertyPlaceholderConfigurer {


    private static Map<String, String> ctxPropertiesMap;

    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    public static String getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }

    public static void setContextProperty(String name,String value) {
         ctxPropertiesMap.put(name, value);
    }

}
