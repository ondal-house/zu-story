package com.zustory.domain.beverage;

import com.zustory.domain.BaseEntity;
import com.zustory.domain.category.Category;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Beverage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beverage_id")
    private Long id;

    @Column
    private String beverageName;

    private String company;

    private String abv;

    private String contents;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
