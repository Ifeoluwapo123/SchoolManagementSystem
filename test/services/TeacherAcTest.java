package services;

import com.management.school.model.Course;
import com.management.school.model.Person;
import com.management.school.services.serviceImplementation.TeacherActions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.naming.NoPermissionException;

public class TeacherAcTest {

    TeacherActions teacherActions;
    Person teacher;

    @BeforeEach()
    public void setup() throws NoPermissionException {
        teacherActions = new TeacherActions();
        teacher = new Person(11, "Ade", "Teacher", "Male");
    }

    public TeacherAcTest() throws NoPermissionException {

    }

    @Test
    public void getRegisteredCourse() {
        Assert.assertNotNull(teacherActions.getRegisteredCourse(teacher));
        Assert.assertNotEquals("",teacherActions.getRegisteredCourse(teacher));
    }
}
