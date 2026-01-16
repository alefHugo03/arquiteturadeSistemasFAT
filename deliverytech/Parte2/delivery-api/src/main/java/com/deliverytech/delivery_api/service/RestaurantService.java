package com.deliverytech.delivery_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.RestaurantDTO;
import com.deliverytech.delivery_api.model.Restaurant;
import com.deliverytech.delivery_api.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> findAll() {
        List<Restaurant> result = restaurantRepository.findAll();
        return result.stream()
                .map(entity -> new RestaurantDTO(entity.getId(), entity.getName(), entity.getAddress()))
                .collect(Collectors.toList());
    }
}