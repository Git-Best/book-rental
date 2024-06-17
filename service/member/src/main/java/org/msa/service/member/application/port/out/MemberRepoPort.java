package org.msa.service.member.application.port.out;

import org.msa.service.member.domain.Member;
import org.msa.service.member.domain.vo.IdName;

public interface MemberRepoPort {
    Member saveMember(Member member);
    Member loadMember(long memberNo);
    Member loadMemberByIdName(IdName idName);
}
