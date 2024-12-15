package com.tesinitsyn.exhibitionservice.service;

import com.tesinitsyn.exhibitionservice.converter.ExhibitionConverter;
import com.tesinitsyn.exhibitionservice.dto.ExhibitionTO;
import com.tesinitsyn.exhibitionservice.model.Exhibition;
import com.tesinitsyn.exhibitionservice.repository.ExhibitionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис выставок.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    /**
     * Retrieves all exhibitions.
     *
     * @return a list of ExhibitionTO objects
     */
    public List<ExhibitionTO> getAllExhibitions() {
        return exhibitionRepository.findAll().stream()
            .map(ExhibitionConverter::toTransferObject)
            .collect(Collectors.toList());
    }

    /**
     * Retrieves an exhibition by its ID.
     *
     * @param id the UUID of the exhibition
     * @return the ExhibitionTO object
     */
    public ExhibitionTO getExhibitionById(UUID id) {
        return exhibitionRepository.findById(id)
            .map(ExhibitionConverter::toTransferObject)
            .orElseThrow(() -> {
                log.error("Exhibition with ID {} not found", id);
                return new RuntimeException("Exhibition not found");
            });
    }

    /**
     * Creates a new exhibition.
     *
     * @param exhibitionTO the ExhibitionTO object
     * @return the created ExhibitionTO object
     */
    public ExhibitionTO createExhibition(ExhibitionTO exhibitionTO) {
        Exhibition exhibition = ExhibitionConverter.toEntity(exhibitionTO);
        Exhibition savedExhibition = exhibitionRepository.save(exhibition);
        return ExhibitionConverter.toTransferObject(savedExhibition);
    }

    /**
     * Updates an existing exhibition.
     *
     * @param id the UUID of the exhibition to update
     * @param exhibitionTO the updated ExhibitionTO object
     * @return the updated ExhibitionTO object
     */
    public ExhibitionTO updateExhibition(UUID id, ExhibitionTO exhibitionTO) {
        Exhibition existingExhibition = exhibitionRepository.findById(id)
            .orElseThrow(() -> {
                log.error("Exhibition with ID {} not found for update", id);
                return new RuntimeException("Exhibition not found");
            });

        existingExhibition.setName(exhibitionTO.getName());
        existingExhibition.setDescription(exhibitionTO.getDescription());
        existingExhibition.setLocation(exhibitionTO.getLocation());
        existingExhibition.setDate(exhibitionTO.getDate());
        existingExhibition.setTime(exhibitionTO.getTime());
        existingExhibition.setPrice(exhibitionTO.getPrice());
        existingExhibition.setImage(exhibitionTO.getImage());
        existingExhibition.setRating(exhibitionTO.getRating());

        Exhibition updatedExhibition = exhibitionRepository.save(existingExhibition);
        return ExhibitionConverter.toTransferObject(updatedExhibition);
    }

    /**
     * Deletes an exhibition by its ID.
     *
     * @param id the UUID of the exhibition to delete
     */
    public void deleteExhibition(UUID id) {
        Optional<Exhibition> exhibitionOptional = exhibitionRepository.findById(id);
        if (exhibitionOptional.isEmpty()) {
            log.error("Exhibition with ID {} not found for deletion", id);
            throw new RuntimeException("Exhibition not found");
        }

        exhibitionRepository.deleteById(id);
    }
}

