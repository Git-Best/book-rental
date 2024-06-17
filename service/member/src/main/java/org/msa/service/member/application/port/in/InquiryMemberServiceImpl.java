package org.msa.service.member.application.port.in;

import lombok.RequiredArgsConstructor;
import org.msa.service.member.adaptor.in.web.dto.InquiryMemberService;
import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;
import org.msa.service.member.application.port.out.MemberRepoPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InquiryMemberServiceImpl implements InquiryMemberService {

    private final MemberRepoPort memberRepoPort;

    @Override
    public MemberOutPutDto getMember(long memberNo) {
        return MemberOutPutDto.mapToDto(memberRepoPort.loadMember(memberNo));
    }
}
