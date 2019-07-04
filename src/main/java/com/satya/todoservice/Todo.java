package com.satya.todoservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "to_do")
public class Todo {
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "description")
    private String description;
}
