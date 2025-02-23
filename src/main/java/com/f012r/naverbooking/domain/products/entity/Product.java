package com.f012r.naverbooking.domain.products.entity;

import com.f012r.naverbooking.domain.categories.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "event", length = 4000)
    private String event;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

}