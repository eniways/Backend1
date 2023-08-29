package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.ApplicationUser;

public interface UserService {

    /**
     * Find a user in the context of Spring Security based on the email address
     * <br>
     * For more information have a look at this tutorial:
     * https://www.baeldung.com/spring-security-authentication-with-a-database
     *
     * @param id
     * @return a application user
     */
    ApplicationUser getUserById(Long id);

    /**
     * Find an application user based on the email address.
     *
     * @return a application user
     */
    ApplicationUser[] getAll();

    /**
     * Delete applicaiton user
     */
    void deleteUserById(Long id);


    /**
     * Create applicaiton user
     *
     * @return a application user
     */
    ApplicationUser createUser(ApplicationUser user);

    /**
     * Update applicaiton user
     *
     * @return a application user
     */
    ApplicationUser updateUser(ApplicationUser user);
}
