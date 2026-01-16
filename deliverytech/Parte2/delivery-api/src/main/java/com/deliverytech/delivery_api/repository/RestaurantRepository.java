package com.deliverytech.delivery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliverytech.delivery_api.model.Restaurant;

// Ao estender JpaRepository, você ganha métodos prontos: findAll, save, delete, etc.
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}