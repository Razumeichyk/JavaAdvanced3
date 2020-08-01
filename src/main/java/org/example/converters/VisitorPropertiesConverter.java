package org.example.converters;

import org.example.config.PropertiesVisitor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@ConfigurationPropertiesBinding
@Component
public class VisitorPropertiesConverter implements Converter<String, PropertiesVisitor> {
    @Override
    public PropertiesVisitor convert(String s) {
        // John,30,10
        String[] data = s.split(",");
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        int hourArrival = Integer.parseInt(data[2]);
        return new PropertiesVisitor(name, age, hourArrival);
    }
}
