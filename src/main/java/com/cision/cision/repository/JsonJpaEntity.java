package com.cision.cision.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "images")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    private String timestamp;

    private long size;
}
