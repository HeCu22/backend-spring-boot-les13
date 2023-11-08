package com.example.les13relations.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {
    public Long id;

    public String title;

    public int sp;

    public Long teacherId;

    public List<String> lessonTitles = new ArrayList<>();
}
