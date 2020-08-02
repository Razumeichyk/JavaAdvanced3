package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.User;
import org.example.dto.UserDto;
import org.example.events.AfterAddingUserEvent;
import org.example.events.BeforeAddingUserEvent;
import org.example.mappers.UserMapper;
import org.example.repositories.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    private ApplicationEventPublisher publisher;

    public UserService(UserRepository userRepository, UserMapper userMapper, ApplicationEventPublisher eventPublisher){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.publisher = eventPublisher;
    }

    public List<UserDto> findByNames(String username1, String username2, String email){
        return userRepository.findByNames(username1, username2, email)
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto addUser(UserDto userFromController){
        // receives DTO - Data Transfer Object
//        System.out.println("Before publishing the first event");
        log.info("Before adding user");
//        this.publisher.publishEvent(new BeforeAddingUserEvent(userFromController, LocalDateTime.now()));
//        System.out.println("After publishing the first event");

        User user = userMapper.userDtoToUser(userFromController);
        // translate DTO to domain model
        userRepository.add(user);
        // we need to translate user model to user dto
        UserDto returnedUserDto = userMapper.userToUserDto(user);

        System.out.println("Before publishing the second event");
        this.publisher.publishEvent(new AfterAddingUserEvent(returnedUserDto, LocalDateTime.now()));
        System.out.println("After publishing the second event");
        //returns the DTO
        return returnedUserDto;
    }
}
