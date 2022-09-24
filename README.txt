Assumptions I've made: Searches for books are only done using title. Application considered as a happy day scenario ie. only correct parameters will work

Setup application.properties file by adding this to it:

	spring.datasource.url=jdbc:postgresql://localhost:portNumber/postgres
	spring.datasource.username=postgres
	spring.datasource.password=yourpostgrespassword
	spring.jpa.show-sql=true
	
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.jpa.hibernate.ddl-auto=update
	
How to run:
    Application was developed in a Linux environment using STS IDE (Spring Boot IDE)

    First clone or download master branch code from github: https://github.com/ashilr11/zss.git
    
    Open in STS or Eclipse with Spring plugins
    
    Import as Spring Boot Maven application and run
    
    HTTP Requests you can do using PostMan:
    
    	1. Retrieve all books using GET, url -> http://localhost:8080/books
    	
    	2. Retrieve a specific book using GET title (book title) as query parameter, url -> http://localhost:8080/book?title=BookName
    	
    	3. Post a book to the postgresql database using POST, url -> http://localhost:8080/books
    		Add the JSON document in the postman HTTP body, a bookID will be auto generated for example you can use:
    				{
					    "title": "BookName",
					    "description": "Your Book",
					    "price": 34.99,
					    "category": {
					        "title": "thriller",
					        "catId": 1
					    }
					}	
					
		 	Or insert directly into postgresql using -> INSERT INTO categories (cat_id, title) VALUES (5, 'sci-fi');
    	
    	4. Retrieve all categories using GET -> http://localhost:8080/categories
    	
    	5. Retrieve all books in a category using GET and title (category title) as query parameter -> http://localhost:8080/category?title=CategoryName
    	
    	6. Post a new category using POST. Url -> http://localhost:8080/categories
	    	Add the JSON document in the postman HTTP body. For example you can use:
	    				{
	        				"title": "thriller",
	        				"catId": 1
	    				}
    		Or insert directly into postgresql using -> INSERT INTO books (book_id, title, description, price, cat_id) VALUES (8, 'BookName', 'yes', 34.69, 4);
    				
    	7. Purchase a book using POST with query parameters title (book title), cardID and cardExpiry, url -> http://localhost:8080/purchase?title=BookName&cardID=1234560000000001&cardExpiry=2020-01-01
