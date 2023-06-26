package com.balkovyy.watchlist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balkovyy.watchlist.Entities.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

}
