# REST web services
## Creating RESTful web services using Jersey
> We will create a web service for the Course Management example that we have been developing in this book. The web service will have methods to get all courses and create a new course. To keep the example simple, we will not write the data access code (you could use the JDBC or JDO APIs that we have learnt in the previous chapters), but will hardcode the data.
### Teacher and Course
#### 如果不用@XMLAttribute
> We have annotated the id fields in both classes as @XMLAttribute. If objects of these classes are marshalled (converted from Java objects) to XML, Course id and Teacher id would be the attributes (instead of elements) of the root element (Course and Teacher, respectively). If no filed annotation is specified and if public getters/setters for an attribute are present, then it is considered an XML element with the same name.
#### 
