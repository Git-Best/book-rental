package org.msa.service.member.adaptor.out.persistence;

import org.msa.service.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member, Long> {
}
