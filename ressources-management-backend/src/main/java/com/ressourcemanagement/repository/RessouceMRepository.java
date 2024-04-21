package com.ressourcemanagement.repository;

import com.ressourcemanagement.model.RessourceMaterielle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessouceMRepository extends JpaRepository<RessourceMaterielle, Long> {

}
