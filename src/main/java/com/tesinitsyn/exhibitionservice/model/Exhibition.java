package com.tesinitsyn.exhibitionservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Table(name = "exhibition")
@Getter
@Setter
@Entity
public class Exhibition {

    /**
     * Идентификатор.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
