package org.msa.service.member.adaptor.in.web.dto;

import lombok.Data;

@Data
public class MemberInfoDto {
    private String id;
    private String name;
    private String password;
    private String email;
}
