package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.UserDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.ApplicationUser;
import at.ac.tuwien.sepm.groupphase.backend.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PermitAll
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setName(user.getName());
        ApplicationUser createdUser = userService.createUser(applicationUser);
        UserDto createdUserDto = new UserDto();
        createdUserDto.setName(createdUser.getName());
        createdUserDto.setId(createdUser.getId());
        return createdUserDto;
    }


    @PermitAll
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }



}
