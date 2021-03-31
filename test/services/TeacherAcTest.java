package services;

import com.management.school.model.Course;
import com.management.school.model.Person;
import com.management.school.services.serviceImplementation.TeacherActions;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NoPermissionException;

public class TeacherAcTest {
    TeacherActions teacherActions = new TeacherActions();
    Person teacher = new Person(11, "Ade", "Teacher", "Male");

    public TeacherAcTest() throws NoPermissionException {

    }

    @Test
    public void getRegisteredCourse() {
        Assert.assertNotNull(teacherActions.getRegisteredCourse(teacher));
    }
}
