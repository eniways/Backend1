package at.ac.tuwien.sepm.groupphase.backend.service.impl;

import at.ac.tuwien.sepm.groupphase.backend.entity.ApplicationUser;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.repository.UserRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ApplicationUser getUserById(Long id) throws NotFoundException {
        LOGGER.debug("Load a user by id");
        try {
            return userRepository.getApplicationUserById(id);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage(), e);
        }
    }

    @Override
    public ApplicationUser[] getAll() {
        //return (ApplicationUser[]) userRepository.getAll().toArray();
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public ApplicationUser createUser(ApplicationUser user) {
        return userRepository.save(user);
    }

    @Override
    public ApplicationUser updateUser(ApplicationUser user) {
        return userRepository.save(user);
    }
}
