package com.zustory.domain.board;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zustory.domain.BaseEntity;
import com.zustory.domain.category.Category;
import com.zustory.domain.user.User;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Comment("게시글 제목")
    private String title;

    @Comment("게시글 내용")
    private String contents;

    @Comment("게시글 조회 수")
    private int views;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
