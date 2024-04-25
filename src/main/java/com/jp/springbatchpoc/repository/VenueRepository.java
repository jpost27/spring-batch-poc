package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.Venue;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VenueRepository extends JPRepository<Venue, Integer> {

    Venue findByLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude);

}
