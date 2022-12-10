package com.zustory.domain.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zustory.domain.BaseEntity;
import com.zustory.domain.beverage.Beverage;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Comment("카테고리 이름")
    @Column(name = "type", length = 60, nullable = false)
    private String type;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Beverage> beverages;

    @Builder
    public Category(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
