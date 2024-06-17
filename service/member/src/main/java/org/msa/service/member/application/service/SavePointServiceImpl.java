package org.msa.service.member.application.service;

import lombok.RequiredArgsConstructor;
import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;
import org.msa.service.member.application.port.in.SavePointService;
import org.msa.service.member.application.port.out.MemberRepoPort;
import org.msa.service.member.domain.Member;
import org.msa.service.member.domain.vo.IdName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SavePointServiceImpl implements SavePointService {

    private final MemberRepoPort memberRepoPort;

    @Override
    public MemberOutPutDto savePoint(IdName idName, Long point) {
        Member member = memberRepoPort.loadMemberByIdName(idName);
        member.savePoint(point);
        return MemberOutPutDto.mapToDto(member);
    }
}
