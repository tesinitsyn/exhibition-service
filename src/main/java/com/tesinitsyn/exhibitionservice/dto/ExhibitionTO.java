package com.tesinitsyn.exhibitionservice.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class ExhibitionTO {

    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Название выставки.
     */
    private String name;

    /**
     * Описание выставки.
     */
    private String description;

    /**
     * Место проведения.
     */
    private String location;

    /**
     * Дата проведения.
     */
    private String date;

    /**
     * Время проведения.
     */
    private String time;

    /**
     * Цена билета.
     */
    private String price;

    /**
     * Ссылка на изображение.
     */
    private String image;

    /**
     * Рейтинг.
     */
    private Float rating;
}
