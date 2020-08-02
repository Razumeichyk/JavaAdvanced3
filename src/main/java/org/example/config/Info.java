package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "info")
public class Info {

    private PropertiesCategory category;
    private Person person;
}
