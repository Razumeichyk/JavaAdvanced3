package org.example.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "modules", enableByDefault = true)
public class ModulesActuator {

    private List<String> modules = new ArrayList<>(Arrays.asList("MainModule", "AccountsModule",
            "CustomersModules", "SuppliersModule"));

    @ReadOperation
    public List<String> getModules(){
        return modules;
    }

    @ReadOperation
    public String getModule(@Selector String moduleName){
        return modules.stream()
                .filter(module -> module.equals(moduleName))
//                .collect(Collectors.toList())
//                .get(0); //If the list is empty, I get thrown away by IndexOutOfBoundException
                .findFirst().orElse("[Not found]");
    }
}
