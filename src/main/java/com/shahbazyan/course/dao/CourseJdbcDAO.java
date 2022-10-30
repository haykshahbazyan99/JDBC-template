package com.shahbazyan.course.dao;

import com.shahbazyan.course.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJdbcDAO implements DAO<Course> {


    private static final Logger log = LoggerFactory.getLogger(CourseJdbcDAO.class);

    private JdbcTemplate jdbcTemplate;

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course();
        course.setCourseId(rs.getInt("id"));
        course.setTitle(rs.getString("title"));
        course.setDescription(rs.getString("description"));
        course.setLink(rs.getString("link"));
        return course;
    };

    @Override
    public List<Course> list() {
        String sql = "SELECT id, title, description, link from course";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Course course) {
        String sql = "insert into course(title,description,link) values(?,?,?)";
        int insert = jdbcTemplate.update(sql,course.getTitle(),course.getDescription(),course.getLink());
        if(insert == 1) {
            log.info("New Course Created: " + course.getTitle());
        }
    }


    @Override
    public void update(Course course, int id) {
        String sql = "update course set title = ?, description = ?, link = ? where course_id = ?";
        int update = jdbcTemplate.update(sql,course.getTitle(),course.getDescription(),course.getLink(),id);
        if(update == 1) {
            log.info("Course Updated: " + course.getTitle());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from course where id = ?";
        int delete = jdbcTemplate.update(sql,id);
        if(delete == 1) {
            log.info("Course Deleted: " + id);
        }
    }
}
