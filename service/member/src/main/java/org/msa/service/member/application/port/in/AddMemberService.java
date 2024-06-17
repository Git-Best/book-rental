package org.msa.service.member.application.port.in;

import org.msa.service.member.adaptor.in.web.dto.MemberInfoDto;
import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;

public interface AddMemberService {
    MemberOutPutDto addmember(MemberInfoDto memberInfoDto);
}
