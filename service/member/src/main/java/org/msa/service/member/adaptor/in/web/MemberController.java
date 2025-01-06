package org.msa.service.member.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import org.msa.service.member.adaptor.in.web.dto.MemberInfoDto;
import org.msa.service.member.adaptor.in.web.dto.MemberOutPutDto;
import org.msa.service.member.application.port.in.AddMemberService;
import org.msa.service.member.application.port.in.InquiryMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final AddMemberService addMemberService;
    private final InquiryMemberService inquiryMemberService;

    @PostMapping("/Member/")
    public ResponseEntity<MemberOutPutDto> addMember(@RequestBody MemberInfoDto memberInfoDto) {
        MemberOutPutDto addedMember = addMemberService.addmember(memberInfoDto);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }

    @GetMapping("/Member/{no}")
    public ResponseEntity<MemberOutPutDto> getMember(@PathVariable("no") long no) {
        MemberOutPutDto member = inquiryMemberService.getMember(no);
        return member != null
                ? new ResponseEntity<>(member, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
