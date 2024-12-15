package com.tesinitsyn.exhibitionservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tesinitsyn.exhibitionservice.transfer.ExhibitionTO;
import com.tesinitsyn.exhibitionservice.service.ExhibitionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exhibitions")
@AllArgsConstructor
@Log4j2
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    /**
     * Gets all exhibitions.
     *
     * @return List of ExhibitionTO
     */
    @GetMapping
    public ResponseEntity<List<ExhibitionTO>> getAllExhibitions() {
        List<ExhibitionTO> exhibitions = exhibitionService.getAllExhibitions();
        return ResponseEntity.ok(exhibitions);
    }

    /**
     * Gets an exhibition by ID.
     *
     * @param id UUID of the exhibition
     * @return ExhibitionTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExhibitionTO> getExhibitionById(@PathVariable UUID id) {
        try {
            ExhibitionTO exhibition = exhibitionService.getExhibitionById(id);
            return ResponseEntity.ok(exhibition);
        } catch (RuntimeException e) {
            //log.error("Error fetching exhibition with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Creates a new exhibition.
     *
     * @param exhibitionTO ExhibitionTO to create
     * @return Created ExhibitionTO
     */
    @PostMapping
    public ResponseEntity<ExhibitionTO> createExhibition(@RequestBody ExhibitionTO exhibitionTO) {
        ExhibitionTO createdExhibition = exhibitionService.createExhibition(exhibitionTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExhibition);
    }

    /**
     * Updates an exhibition by ID.
     *
     * @param id UUID of the exhibition to update
     * @param exhibitionTO Updated ExhibitionTO
     * @return Updated ExhibitionTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExhibitionTO> updateExhibition(@PathVariable UUID id, @RequestBody ExhibitionTO exhibitionTO) {
        try {
            ExhibitionTO updatedExhibition = exhibitionService.updateExhibition(id, exhibitionTO);
            return ResponseEntity.ok(updatedExhibition);
        } catch (RuntimeException e) {
            //log.error("Error updating exhibition with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Deletes an exhibition by ID.
     *
     * @param id UUID of the exhibition to delete
     * @return No content status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibition(@PathVariable UUID id) {
        try {
            exhibitionService.deleteExhibition(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            //log.error("Error deleting exhibition with ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

