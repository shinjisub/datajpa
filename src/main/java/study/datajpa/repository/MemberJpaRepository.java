package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {

    @PersistenceContext //### Spring 컨테이너가 JPA있는 영속성 컨포넌트를 가져다준다.
    private EntityManager em;

    //### 저장
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    //### 삭제
    public void delete(Member member) {
        em.remove(member);
    }

    //### 특정데이터 찾기
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    //### 특정데이터 찾기 ( Optional )
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));//### 반환하는 타입이 Null or Not NUll 일수도잇다..
    }

    //### 총갯수 구하기
    public long count(Long id) {
        return em.createQuery("select count(m) from Member m", long.class).getSingleResult();
    }

    //### 전체찾기
    public List<Member> findAll() {
        List<Member> memberList = em.createQuery("select m from Member m", Member.class).getResultList();
        return memberList;
    }



}
