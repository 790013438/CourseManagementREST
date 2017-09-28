package snippets.jee.rest.ws.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import snippets.jee.rest.ws.dto.Course;
import snippets.jee.rest.ws.dto.Teacher;

@Path("/course")
public class CourseService {

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("get/{courseId}")
    public Course getCourse (@PathParam("courseId") int id) {

        //To keep the example simple, we will return 
        //hardcoded value here. However, you could get 
        //data from database using, for example, JDO, or JDBC
        
        return new Course(id, "Course-" + id, 5, new Teacher(2, "Teacher1"));
    }

}
