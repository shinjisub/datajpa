package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "userName", "age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;
    private int age;
    private String userName;

    /**
     * 한명의 회원은 한팀에게만 속한다.
     * 연관관계에 속한것은 전부 LAZY(지연로딩)로 해야 성능최적화 할수있다.
     * 지연로딩은 Member를 조회할때 Member테이블만 조회하고 Team 테이블의 값은 가짜객체로 생성해놓고 Team테이블 데이터가 필요할때 그떄 가져온다.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String username, int pAge, Team pTeam) {
        this.userName = username;
        this.age = pAge;
        if(pTeam != null) {
            changeTeam(pTeam);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
    }

}
