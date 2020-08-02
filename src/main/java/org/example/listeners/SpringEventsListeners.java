package org.example.listeners;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class SpringEventsListeners {

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent event){
        System.out.println("Context refreshed!");
    }

    @EventListener
    public void onContextStarted(ContextStartedEvent event){
        System.out.println("Context started!");
    }

    @EventListener
    public void onContextStopped(ContextStoppedEvent event){
        System.out.println("Context stopped!");
    }

    @EventListener
    public void onContextClosed(ContextClosedEvent event){
        System.out.println("Context closed!");
    }
}
