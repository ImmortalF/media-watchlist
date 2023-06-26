package com.balkovyy.watchlist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balkovyy.watchlist.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
