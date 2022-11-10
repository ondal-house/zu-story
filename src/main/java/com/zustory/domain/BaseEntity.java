package com.zustory.domain;

import com.zustory.domain.user.User;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    // @CreatedBy
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdUser;

    // @LastModifiedBy
    @ManyToOne
    @JoinColumn(name = "modified_by")
    private User modifiedUser;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;
}
