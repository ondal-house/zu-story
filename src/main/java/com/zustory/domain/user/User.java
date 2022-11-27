package com.zustory.domain.user;

import com.zustory.domain.BaseEntity;
import com.zustory.domain.board.Board;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String loginId;

    @Column(name = "user_name")
    private String name;

    private String profileImage;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(String name) {
        this.name = name;
    }
}
