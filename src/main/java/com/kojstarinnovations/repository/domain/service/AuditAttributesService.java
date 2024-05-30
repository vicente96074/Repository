package com.kojstarinnovations.repository.domain.service;

import com.kojstarinnovations.repository.domain.model.AuditAttributesDTO;

import java.time.LocalDateTime;

public class AuditAttributesService {

    public static AuditAttributesDTO getAuditAttributesForNew(AuditAttributesDTO dto) {

        dto.setCreatedBy(1);
        dto.setCreatedAt(LocalDateTime.now());
        dto.setUpdatedBy(1);
        dto.setUpdatedAt(LocalDateTime.now());
        dto.setBranchId(1);

        return dto;
    }
}
