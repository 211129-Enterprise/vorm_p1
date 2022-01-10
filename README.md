<b>VORM</b>

Simple ORM for complex tasks

Steps to configure

1. Load project dependecy in your POM.

  <dependencies>
	  <dependency>
		  <groupId>com.vorm</groupId>
		  <artifactId>Viral-O</artifactId>
		  <version>0.0.1-SNAPSHOT</version>
	  </dependency>
  </dependencies>

2. Run mvn install
3. Set up Annotation
4. Set up Configuration
5. Set up Exection

Annotations

This uses Annotations and reflection at runtime to scan class to db entity.

   @Entity
   @Id
   @Column
   
      @Entity
      This is the most important annotation and triggers db creation.
      
      Annotate data or model class with this annotation. 
      It requires to provide tableName.
      Eg. @Entity(tableName = "demo1")
      
      @Id
      This is for primary Id.
      Field marked is mapped to primary key field in DB.
      Requires columnName specification.
      @Id(columnName = "demo1class_id")
      
      @Column
      This is to mark columns to be added to target tablet.
      Automatically determines if DB column will be string or numeric.
      Requires columnName specification.
      @Column(columnName = "demo1class_name")
      

Step for Configuration

1. Create a file "application.properties" in java/resources folder.
2. Pouplate with desired database parameters
    Eg,
      awsurl=jdbc:postgresql://localhost/postgres
      awsuser=postgres
      awspass=postgres
      cascade=true
3.  Cascade properties determine if tables are dropped when re running application.


Steps for Execution

1.  Instantiate Configuration object from com.vorm.util.Configuration.
      Eg, Configuration configuration = new Configuration();
2.  Instantiate Execute object from com.vorm.sql.Execute.
      Eg, Execute runner = new Execute();
3.  Add annotated class to configuration object.
      Eg, configuration.addAnnotatedClass(Demo1Class.class);
4.  Call execute from runner and pass configuration object.
      Eg, runner.execute(configuration);
      
      



      
      
 
