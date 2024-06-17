package org.msa.service.member.adaptor.out.persistence;


import lombok.RequiredArgsConstructor;
import org.msa.service.member.application.port.out.MemberRepoPort;
import org.msa.service.member.domain.Member;
import org.msa.service.member.domain.vo.IdName;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepoAdaptor implements MemberRepoPort {

    private final MemberRepo memberRepo;

    @Override
    public Member saveMember(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public Member loadMember(long memberNo) {
        return null;
    }

    @Override
    public Member loadMemberByIdName(IdName idName) {
        return null;
    }
}
