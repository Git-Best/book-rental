package org.msa.service.rental.adaptor.in.web.dto;

import lombok.Data;

@Data
public class UserItemInputDto {
    private String userId;
    private String userName;
    private Integer itemId;
    private String itemTitle;
}
