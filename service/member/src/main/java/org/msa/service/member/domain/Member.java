package org.msa.service.member.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msa.service.member.domain.vo.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @Embedded
    private IdName idName;

    @Embedded
    private Password password;

    @Embedded
    private Email email;

    @ElementCollection
    private List<Authority> authorities = new ArrayList<>();

    @Embedded
    private Point point;

    public static Member registerMember(IdName idName, Password pwd, Email email) {
        Member member = new Member();
        member.idName = idName;
        member.password = pwd;
        member.email = email;
        member.point = new Point();
        member.addAuthority(new Authority(UserRole.USER));
        return member;
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void savePoint(long point) {
        this.point.addPoint(point);
    }

    public void usePoint(long point) {
        this.point.removePoint(point);
    }

    public Member login(IdName idName, Password password) {
        return this;
    }

    public void logout(IdName idName) {
        // 껍데기
    }
}
