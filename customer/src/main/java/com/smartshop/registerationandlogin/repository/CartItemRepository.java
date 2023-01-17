package com.smartshop.registerationandlogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartshop.registerationandlogin.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	@Query("SELECT c FROM CartItem c WHERE c.user.userId = :userId")
	List<CartItem> findCartItemByUserId(@Param("userId") Integer userId);

	@Modifying
	@Query("update CartItem c set c.quantity = :quantity where c.id = :id")
	void updateQuantity(@Param("quantity") Integer quantity, @Param("id") Integer id);

}
