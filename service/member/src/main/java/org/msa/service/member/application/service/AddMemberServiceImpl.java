package org.msa.service.member.application.service;


import lombok.RequiredArgsConstructor;
import org.msa.service.member.adaptor.in.web.dto.MemberInfoDto;
import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;
import org.msa.service.member.application.port.in.AddMemberService;
import org.msa.service.member.application.port.out.MemberRepoPort;
import org.msa.service.member.domain.Member;
import org.msa.service.member.domain.vo.Email;
import org.msa.service.member.domain.vo.IdName;
import org.msa.service.member.domain.vo.Password;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddMemberServiceImpl implements AddMemberService {

    private final MemberRepoPort memberRepoPort;

    @Override
    @Transactional
    public MemberOutPutDto addmember(MemberInfoDto memberInfoDto) {
        IdName idName = new IdName(memberInfoDto.getId(), memberInfoDto.getName());
        Password password = new Password(memberInfoDto.getPassword(), memberInfoDto.getPassword());
        Email email = new Email(memberInfoDto.getEmail());
        Member member = Member.registerMember(idName, password, email);

        Member savedMember = memberRepoPort.saveMember(member);
        return MemberOutPutDto.mapToDto(savedMember);
    }
}
