package org.msa.service.rental.adaptor.in.web.dto;

import lombok.Data;

@Data
public class clearOverdueInfoDto {
    private String userId;
    private String UserName;
    private Integer point;
}
