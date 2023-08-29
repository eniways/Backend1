package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class UserDto {

    @NotNull(message = "Id must not be null")
    @Email
    private Long id;

    @NotNull(message = "Name must not be null")
    private String name;

    public @NotNull(message = "Id must not be null") @Email Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto userDto)) {
            return false;
        }
        return Objects.equals(id, userDto.id)
            && Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "UserDto{"
            + "email='" + id + '\''
            + ", password='" + name + '\''
            + '}';
    }


    public static final class UserDtoBuilder {
        private Long id;
        private String name;

        private UserDtoBuilder() {
        }

        public static UserDtoBuilder anUserLoginDto() {
            return new UserDtoBuilder();
        }

        public UserDtoBuilder withEmail(Long id) {
            this.id = id;
            return this;
        }

        public UserDtoBuilder withPassword(String name) {
            this.name = name;
            return this;
        }

        public UserDto build() {
            UserDto userDto = new UserDto();
            userDto.setId(id);
            userDto.setName(name);
            return userDto;
        }
    }
}
