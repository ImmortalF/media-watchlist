package com.balkovyy.watchlist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.balkovyy.watchlist.Entities.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
