package org.example.events;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.UserDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfterAddingUserEvent {

    private UserDto userToBeAdded;
    private LocalDateTime timestamp;
}
