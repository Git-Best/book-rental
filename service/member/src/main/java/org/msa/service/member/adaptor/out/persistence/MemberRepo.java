package org.msa.service.member.adaptor.out.persistence;

import java.util.Optional;
import org.msa.service.member.domain.Member;
import org.msa.service.member.domain.vo.IdName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Long> {

    public Optional<Member> findMemberByIdName(IdName idName);
}
