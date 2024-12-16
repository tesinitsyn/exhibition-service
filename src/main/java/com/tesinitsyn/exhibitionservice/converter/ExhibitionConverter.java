package com.tesinitsyn.exhibitionservice.converter;


import com.tesinitsyn.exhibitionservice.model.Exhibition;
import com.tesinitsyn.exhibitionservice.transfer.ExhibitionTO;
import org.springframework.beans.BeanUtils;
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
        // Мб вкусовщина, но билдер тут выглядит уместно
        return ExhibitionTO.builder()
                .id(exhibition.getId())
                .name(exhibition.getName())
                .description(exhibition.getDescription())
                .location(exhibition.getLocation())
                .date(exhibition.getDate())
                .time(exhibition.getTime())
                .price(exhibition.getPrice())
                .image(exhibition.getImage())
                .rating(exhibition.getRating()).build();
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
        //только если у полей одинаковые имена и совместимые типы
        BeanUtils.copyProperties(exhibitionTO, exhibition);
        return exhibition;
    }
}

