package com.anaschenkov.start.domain.entity;

import jakarta.persistence.*;
@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="Student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name="name",length = 100)
    private String name;

    @Column(name="groupp")
    private Integer groupp;
    public Student(String name, int groupp) {
    this.name = name;
    this.groupp=groupp;
    }
    public Student(){
        name="безымянный";
    }
    public int getGroupp(){
        return groupp;
    }

    public void setGroupp(int groupp) {
        this.groupp = groupp;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}