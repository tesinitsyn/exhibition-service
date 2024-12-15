package com.tesinitsyn.exhibitionservice.converter;


import com.tesinitsyn.exhibitionservice.model.Exhibition;
import com.tesinitsyn.exhibitionservice.transfer.ExhibitionTO;
import org.springframework.stereotype.Component;

/**
 * Конвертер для сущности выставки.
 */
@Component
public class ExhibitionConverter {

    /**
     * Converts an Exhibition entity to an ExhibitionTO.
     *
     * @param exhibition the Exhibition entity
     * @return the converted ExhibitionTO
     */
    public static ExhibitionTO toTransferObject(Exhibition exhibition) {
        if (exhibition == null) {
            return null;
        }

        ExhibitionTO exhibitionTO = new ExhibitionTO();
//        exhibitionTO.setId(exhibition.getId());
//        exhibitionTO.setName(exhibition.getName());
//        exhibitionTO.setDescription(exhibition.getDescription());
//        exhibitionTO.setLocation(exhibition.getLocation());
//        exhibitionTO.setDate(exhibition.getDate());
//        exhibitionTO.setTime(exhibition.getTime());
//        exhibitionTO.setPrice(exhibition.getPrice());
//        exhibitionTO.setImage(exhibition.getImage());
//        exhibitionTO.setRating(exhibition.getRating());

        return exhibitionTO;
    }

    /**
     * Converts an ExhibitionTO to an Exhibition entity.
     *
     * @param exhibitionTO the ExhibitionTO
     * @return the converted Exhibition entity
     */
    public static Exhibition toEntity(ExhibitionTO exhibitionTO) {
        if (exhibitionTO == null) {
            return null;
        }

        Exhibition exhibition = new Exhibition();
//        exhibition.setId(exhibitionTO.getId());
//        exhibition.setName(exhibitionTO.getName());
//        exhibition.setDescription(exhibitionTO.getDescription());
//        exhibition.setLocation(exhibitionTO.getLocation());
//        exhibition.setDate(exhibitionTO.getDate());
//        exhibition.setTime(exhibitionTO.getTime());
//        exhibition.setPrice(exhibitionTO.getPrice());
//        exhibition.setImage(exhibitionTO.getImage());
//        exhibition.setRating(exhibitionTO.getRating());

        return exhibition;
    }
}

