package study.datajpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class TeamJpaRepository {

    @PersistenceContext
    private EntityManager em;

    //### 저장
    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    //### 삭제
    public void delete(Team team) {
        em.remove(team);
    }

    //### 총 갯수 조회
    public Long count() {
        return em.createQuery("select count(t) from Team t", Long.class).getSingleResult();
    }

    //### 전체조회
    public List<Team> findAll() {
        List<Team> teamList = em.createQuery("select t from Team t").getResultList();
        return teamList;
    }

    //### 단건 조회
    public Optional<Team> findById(Long id) {
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }



}
