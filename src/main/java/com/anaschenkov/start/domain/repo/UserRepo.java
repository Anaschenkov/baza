package com.anaschenkov.start.domain.repo;

import com.anaschenkov.start.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
