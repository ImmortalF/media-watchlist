package com.balkovyy.watchlist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balkovyy.watchlist.Entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
