package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "info.person")
@Validated
public class Person {
    private boolean enabled;

    @Min(1)
    @Max(3)
    private int numberOfCourses;

    @Size(min = 1, max= 10)
    private String name;

    @NotNull
    private Map<String, String> location;

    private PropertiesVisitor visitor;
}
