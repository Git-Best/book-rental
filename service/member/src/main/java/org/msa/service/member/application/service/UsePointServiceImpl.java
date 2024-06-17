package org.msa.service.member.application.service;

import lombok.RequiredArgsConstructor;
import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;
import org.msa.service.member.application.port.in.UsePointService;
import org.msa.service.member.application.port.out.MemberRepoPort;
import org.msa.service.member.domain.Member;
import org.msa.service.member.domain.vo.IdName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UsePointServiceImpl implements UsePointService {

    private final MemberRepoPort memberRepoPort;

    @Transactional
    @Override
    public MemberOutPutDto usePoint(IdName idName, long point) {
        Member member = memberRepoPort.loadMemberByIdName(idName);
        member.usePoint(point);
        return MemberOutPutDto.mapToDto(member);
    }
}
