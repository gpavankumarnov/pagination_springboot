package com.example.pagination.repository;
import com.example.pagination.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {




}
