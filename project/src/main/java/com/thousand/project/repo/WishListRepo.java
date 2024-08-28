package com.thousand.project.repo;

import com.thousand.project.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList,Long> {
}
