# REST web services
## Creating RESTful web services using Jersey
> We will create a web service for the Course Management example that we have been developing in this book. The web service will have methods to get all courses and create a new course. To keep the example simple, we will not write the data access code (you could use the JDBC or JDO APIs that we have learnt in the previous chapters), but will hardcode the data.
> Using the JAX-RS @Path annotation, we can convert any Java class into a REST resource. Values passed to the @Path annotation are the relative URIs of the resource.  Methods in the implementation class to be executed for different HTTP methods are annotated with one of the following annotations: @GET, @PUT, @POST, or @DELETE.  The @Path annotation can also be used at the method level for a sub-resource path (the main resource or the root resource path is at the class level, again using the @ Path annotation). We can also specify the mime type that these methods produce or consume by using the @Produces or @Consumes annotation, respectively.

### Teacher, Course
> Before we create a web service implementation class, let's create utility classes, more specifically in this case, DTO.  Create the Course and Teacher classes in the packt.jee.eclipse.rest.ws.dto package. We will also annotate them with the JAXB annotations.
> We have specifically used the @XMLElement annotation for name fields because we want to rename them as course_name or teacher_name when marshalled to XML.
### Implementing the REST GET request
```java
@Path("/course")
public class CourseService {
    @GET
    @Produces (MediaType.APPLICATION_XML)
    @Path("get/{courseId}")
    public Course getCourse (@PathParam("courseId") int id) {
         
        //To keep the example simple, we will return
        //hardcoded values here. However, you could get
        //data from database using, for example, JDO or JDBC
        
        return new Course(id,"Course-" + id, 5, new Teacher(2, "Teacher1"));
    }
}
```

> The @Path annotation specifies that resources made available by this class will be accessible by the relative URI "/course".  The getCourse method has many annotations. Let's discuss them one at a time.  The @GET annotation specifies that when the relative URI (as specified by @Path on the CourseService class) "/course" is called using the HTTP GET method, then this method will be invoked.  @Produces (MediaType.APPLICATION_JSON) specifies that this method generates a JSON output. If the client specifies the accepted mime types, then this annotation would be used to resolve the method to be called, if more than one method is annotated with @GET (or, for that matter, any of the other HTTP method annotations).  For example, if we have another method called getCourseJSON annotated with @ GET but producing data with different mime types (as specified by @Produces), then an appropriate method will be selected on the basis of the mime type requested by the client. The mime type in the @Produces annotation also tells the JAX-RS implementation the mime type of the response when marshalling the Java object that is returned from the method. For example, in the getCourse method, we return an instance of Course, and the mime type specified in @Produces tells Jersey to generate an XML representation of this instance.  The @Path annotation can also be used at the method level to specify subresources.  The value specified in @Path at the method level is relative to the path value specified at the class level. The resource (in this case, Course) with ID 20 can be accessed as /course/get/20. The complete URL can be http://<serveraddress>:<port>/<app-name>/course/get/10.  Parameter names in the path value are enclosed in {}.  Path parameters need to be identified in method arguments by using the @PathParam annotation and the name of the parameter as its value. The JAX-RS implementation framework matches the path parameters with arguments matching the @PathParam annotation and appropriately passes the parameter values to the method.

