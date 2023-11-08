package com.example.les13relations.controller;

import com.example.les13relations.dto.LessonDto;
import com.example.les13relations.model.Course;
import com.example.les13relations.model.Lesson;
import com.example.les13relations.repository.CourseRepository;
import com.example.les13relations.repository.LessonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lessons")
public class LessonController {
    private final LessonRepository lessonRepos;
    private final CourseRepository courseRepos;

    public LessonController(LessonRepository lessonRepos, CourseRepository courseRepos) {
        this.courseRepos= courseRepos;
        this.lessonRepos = lessonRepos;
    }

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@RequestBody LessonDto lessonDto) {
        Lesson lesson = new Lesson();

        // mapping
        lesson.setTopic(lessonDto.topic);

        Course course = courseRepos.findById(lessonDto.courseId).get();
        lesson.setCourse(course);

        lessonRepos.save(lesson);
        lessonDto.id = lesson.getId();

        return new ResponseEntity<>(lessonDto, HttpStatus.CREATED);
    }
}
