package com.zhuromska.logger.appenders;

import com.lotos.model.service.SMSService;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.io.Serializable;

@Plugin(name = "SMS", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class SMSAppender extends AbstractAppender {

    protected SMSAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @PluginFactory
    public static SMSAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("PatternLayout") Layout<? extends Serializable> layout) {
        return new SMSAppender(name, null, layout, false);
    }

    @Override
    public void append(LogEvent event) {
        try {
            SMSService.sendSMS(new String(getLayout().toByteArray(event)));
        } catch (Exception exception) {
            System.out.println("MAGIC");
        }
    }
}
