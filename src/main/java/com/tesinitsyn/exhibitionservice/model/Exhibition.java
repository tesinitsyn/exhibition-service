package com.tesinitsyn.exhibitionservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@ToString
@RequiredArgsConstructor
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Exhibition that = (Exhibition) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
