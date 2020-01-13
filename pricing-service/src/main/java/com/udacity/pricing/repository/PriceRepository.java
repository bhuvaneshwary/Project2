package com.udacity.pricing.repository;

import com.udacity.pricing.domain.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

    @RestResource(path = "byVehicleId")
    Price findByVehicleId(@Param("id") Long vehicleId);
}
