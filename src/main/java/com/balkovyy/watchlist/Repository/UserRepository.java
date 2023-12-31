package com.balkovyy.watchlist.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balkovyy.watchlist.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

}
