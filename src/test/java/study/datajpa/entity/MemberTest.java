package study.datajpa.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void toEntity() {
        //### Team객체에 팀명을 생
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");
        entityManager.persist(teamA);
        entityManager.persist(teamB);

        Member memberA = new Member("홍길동", 10, teamA);
        Member memberB = new Member("홍웅표", 21, teamB);

        entityManager.persist(memberA);
        entityManager.persist(memberB);

        //### 초기화
        entityManager.flush();
        entityManager.clear();

        List<Member> memberList = entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        for (Member member : memberList) {
            System.out.println("--------------------");
            System.out.println("memeber : " +member);
            System.out.println("memeber.team() : " +member.getTeam());
        }

//        Assertions.assertThat(memberA.getTeam()).isEqualTo(teamA);
//        Assertions.assertThat(memberB.getTeam()).isEqualTo(teamB);
    }

}