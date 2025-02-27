package com.f012r.naverbooking.domain.products.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "file_info")
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "save_file_name", nullable = false, length = 4000)
    private String saveFileName;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @Column(name = "delete_flag", nullable = false)
    private Integer deleteFlag;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

}