package com.tesinitsyn.exhibitionservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@ToString
@RequiredArgsConstructor
@Table(name = "exhibition")
@Getter
@Setter
@Entity
@EqualsAndHashCode
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
