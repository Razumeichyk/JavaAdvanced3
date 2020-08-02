package org.example.listeners;

import org.example.events.AfterAddingUserEvent;
import org.example.events.BeforeAddingUserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserServiceListeners {

    @Async
    @EventListener
    public void handleBeforeUserAddedEvent(BeforeAddingUserEvent event){
        System.out.println("Before user added timestamp: "+ event.getTimestamp());
    }

    @Async
    @EventListener
    public void handleAfterUserAddedEvent(AfterAddingUserEvent event){
        System.out.println("After user added timestamp: "+ event.getTimestamp());
    }
}
