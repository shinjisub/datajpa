package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.*;

//### @RunWith(SpringRunner.class)   기존에는 JUIT 4일때는 이렇게 사용했지만 ver 5 넘어오면서 스프링부트 와 함께쓸때 이렇게 안해줘도 된다.
@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        Member member = new Member("홍길동", 10, null);
        Member memberSave = memberJpaRepository.save(member);
        Member memberFindId = memberJpaRepository.find(memberSave.getId());

        assertThat(memberFindId.getId()).isEqualTo(memberSave.getId());
        assertThat(memberFindId.getUserName()).isEqualTo(memberSave.getUserName());
        assertThat(memberFindId).isEqualTo(member);
    }

}