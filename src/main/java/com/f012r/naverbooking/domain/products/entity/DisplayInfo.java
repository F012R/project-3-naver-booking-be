package com.f012r.naverbooking.domain.products.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "display_info")
public class DisplayInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "opening_hours", length = 400)
    private String openingHours;

    @Column(name = "place_name",nullable = false, length = 50)
    private String placeName;

    @Column(name = "place_lot", length = 100)
    private String placeLot;

    @Column(name = "place_street", length = 100)
    private String placeStreet;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "homepage", length = 255)
    private String homepage;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

}
