package org.msa.service.rental.adaptor.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserInputDto {
    private String userId;
    private String userNm;
    private Integer itemId;
    private String itemTitle;
}
