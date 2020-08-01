package com.codeup.springblogapp.repositories;

import com.codeup.springblogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post deleteById(long id);

    Post findAllByCategory(String category);

    List<Post> findAllByOwner_Id(long id);

    Post findByTitle(String title);

}
