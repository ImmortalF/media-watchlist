package com.balkovyy.watchlist.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balkovyy.watchlist.Entities.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Optional<Status> findByUserIdAndMediaId(Long userId, Long mediaId);

    boolean existsByUserIdAndMediaId(Long userId, Long mediaId);

    void deleteByUserIdAndMediaId(Long userId, Long mediaId);

}
