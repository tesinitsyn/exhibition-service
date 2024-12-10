package com.tesinitsyn.exhibitionservice.repository;

import com.tesinitsyn.exhibitionservice.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, UUID> {
}
