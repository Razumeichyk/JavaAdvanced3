package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("info.category")
public class PropertiesCategory {
    private String name;
    private String description;
    private boolean used;
    private List<String> items;
}
