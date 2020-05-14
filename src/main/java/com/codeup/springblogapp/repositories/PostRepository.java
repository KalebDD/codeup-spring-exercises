package com.codeup.springblogapp.repositories;

import com.codeup.springblogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post deleteById(long id);

    Post findById(long id);

}
