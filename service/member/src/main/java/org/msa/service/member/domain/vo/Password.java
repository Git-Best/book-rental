package org.msa.service.member.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Password {
    private String presentPwd;
    private String pastPwd;
}
