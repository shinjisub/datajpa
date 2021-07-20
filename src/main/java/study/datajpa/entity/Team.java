package study.datajpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    public Team(String teamName) {
        this.name = teamName;
    }

    @OneToMany(mappedBy = "team")//### 한팀의 여러명의 회원이 있을수있다. Join을 할때 FK가 없는 쪽에 mappedBy해준다.
    private List<Member> members = new ArrayList<Member>();

}
