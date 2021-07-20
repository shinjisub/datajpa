package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Team;

/*
    - TeamRepository가 동작가능한 이유
        ㄴTeamRepository.getClass() -> 프록시 생성


    @Repository 생략가능한 이유
    - 컴퍼넌트 스캔을 Spring JPA가 자동으로 처리
    - JPA 예외를 스프링 예외로 변환하는 과정도 자동으로 처
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
}
