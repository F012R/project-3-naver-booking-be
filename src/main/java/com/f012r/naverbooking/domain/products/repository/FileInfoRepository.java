package com.f012r.naverbooking.domain.products.repository;

import com.f012r.naverbooking.domain.products.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {
}
