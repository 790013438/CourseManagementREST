# REST web services
## Creating RESTful web services using Jersey
> We will create a web service for the Course Management example that we have been developing in this book. The web service will have methods to get all courses and create a new course. To keep the example simple, we will not write the data access code (you could use the JDBC or JDO APIs that we have learnt in the previous chapters), but will hardcode the data.
> Using the JAX-RS @Path annotation, we can convert any Java class into a REST resource. Values passed to the @Path annotation are the relative URIs of the resource.  Methods in the implementation class to be executed for different HTTP methods are annotated with one of the following annotations: @GET, @PUT, @POST, or @DELETE.  The @Path annotation can also be used at the method level for a sub-resource path (the main resource or the root resource path is at the class level, again using the @ Path annotation). We can also specify the mime type that these methods produce or consume by using the @Produces or @Consumes annotation, respectively.

### Teacher, Course
> Before we create a web service implementation class, let's create utility classes, more specifically in this case, DTO.  Create the Course and Teacher classes in the packt.jee.eclipse.rest.ws.dto package. We will also annotate them with the JAXB annotations.
> We have specifically used the @XMLElement annotation for name fields because we want to rename them as course_name or teacher_name when marshalled to XML.
