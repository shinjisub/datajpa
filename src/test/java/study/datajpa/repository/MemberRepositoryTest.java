package study.datajpa.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = new Member("New 1홍길동", 10, null);
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId()).get();

        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getUserName()).isEqualTo(findMember.getUserName());
        Assertions.assertThat(member).isEqualTo(findMember);
    }


    @Test
    public void basicCRUD() {
        Member member = new Member("New 1홍길동", 10, null);
        Member member2 = new Member("New 2홍길동", 20, null);
        memberRepository.save(member);
        memberRepository.save(member2);

        //### 단건검증 조회
        Member findMember1 = memberRepository.findById(member.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();

        //### 변경감지 (더티체킹) insert 후에 update로 수정이된다.
        findMember1.setUserName("Update 홍길동");

    /*
        Assertions.assertThat(member).isEqualTo(findMember1);
        Assertions.assertThat(member2).isEqualTo(findMember2);

        //### 전체검색 검증
        List<Member> memberList = memberRepository.findAll();

        //### 갯수검증
        Long memberCnt = memberRepository.count();

        Assertions.assertThat(memberList.size()).isEqualTo(2);
        Assertions.assertThat(memberCnt).isEqualTo(2);

        //### 삭제검증
        memberRepository.delete(findMember1);
        memberRepository.delete(findMember2);
        Assertions.assertThat(memberRepository.count()).isEqualTo(0);
     */

    }
}