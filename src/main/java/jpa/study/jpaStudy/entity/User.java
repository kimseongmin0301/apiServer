package jpa.study.jpaStudy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="PHONE", nullable = false)
    private String phone;

    @Column(name="CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="UPDATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    protected void onCreate(){
        createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }
}
