package snippets.jee.rest.ws.services;

@Path("/course")
public class CourseService {

    @GET
    @Produces (MediaType.APPLICATION_XML)
    @Path("get/{courseId}")
    public Course getCourse (@PathParam("courseId") int id) {

        //To keep the example simple, we will return 
        //hardcoded value here. However, you could get 
        //data from database using, for example, JDO, or JDBC
        
        return new Course(id, "Course-" + id, 5, new Teacher(2, "Teacher1"));
    }

}
