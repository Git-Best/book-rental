package org.msa.service.member.adaptor.in.web.dto;

import lombok.Data;
import org.msa.service.member.domain.Member;

@Data
public class MemberOutPutDto {
    private String id;
    private String name;
    private String password;
    private String email;
    private long point;

    public static MemberOutPutDto mapToDto(Member member) {
        MemberOutPutDto dto = new MemberOutPutDto();
        dto.setId(member.getIdName().getId());
        dto.setName(member.getIdName().getName());
        dto.setPassword(member.getPassword().getPresentPwd());
        dto.setEmail(member.getEmail().getAddress());
        dto.setPoint(member.getPoint().getPointValue());
        return dto;
    }
}
