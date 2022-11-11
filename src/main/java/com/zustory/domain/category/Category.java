package com.zustory.domain.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zustory.domain.BaseEntity;
import com.zustory.domain.beverage.Beverage;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Comment("카테고리 이름")
    private String type;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Beverage> beverages = new ArrayList<>();
}
