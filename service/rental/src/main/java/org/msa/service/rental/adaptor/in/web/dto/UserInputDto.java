package org.msa.service.rental.adaptor.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInputDto {
    private String userId;
    private String userName;
    private Integer itemId;
    private String itemTitle;
}
