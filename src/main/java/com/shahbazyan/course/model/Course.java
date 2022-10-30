package com.shahbazyan.course.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {

    private int courseId;
    private String title;
    private String description;
    private String link;


    public Course(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }


}
