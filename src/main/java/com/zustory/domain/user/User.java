package com.zustory.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zustory.domain.BaseEntity;
import com.zustory.domain.board.Board;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Comment("소셜 id")
    private String loginId;

    @Comment("사용자 이름")
    @Column(name = "user_name")
    private String name;

    @Comment("사용자 이미지 url")
    private String profileImage;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(String name) {
        this.name = name;
    }
}
