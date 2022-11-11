package com.zustory.domain.beverage;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zustory.domain.BaseEntity;
import com.zustory.domain.category.Category;
import javax.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class Beverage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beverage_id")
    private Long id;

    @Comment("주류 이름")
    @Column
    private String beverageName;

    @Comment("주류 회사 명")
    private String company;

    @Comment("주류 도수")
    private String abv;

    @Comment("주류 설명")
    private String contents;

    @Comment("주류 소개 이미지")
    private String imageUrl;

    @Comment("주류 카테고리")
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Builder
    public Beverage(
            String beverageName, String company, String abv, String contents, String imageUrl, Category category) {
        this.beverageName = beverageName;
        this.company = company;
        this.abv = abv;
        this.contents = contents;
        this.imageUrl = imageUrl;
        this.category = category;
    }
}
