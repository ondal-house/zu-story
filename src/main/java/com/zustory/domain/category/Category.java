package com.zustory.domain.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zustory.domain.BaseEntity;
import com.zustory.domain.beverage.Beverage;
import com.zustory.domain.board.Board;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String type;

    @OneToMany(mappedBy = "category")
    private List<Beverage> beverages = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Board> boards = new ArrayList<>();
}
