package org.msa.service.member.application.port.in;

import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;
import org.msa.service.member.domain.vo.IdName;

public interface UsePointService {
    MemberOutPutDto usePoint(IdName idName, long point);
}
