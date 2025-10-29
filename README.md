🍴 Food Catalogue Service

A Spring Boot microservice that manages restaurant menu items.

🚀 Features

Add, update, delete, and fetch food items

Filter items by restaurant

Supports Veg/Non-Veg classification

Ready for inter-service communication (Feign/RestTemplate)

🧱 Tech Stack

Java 17, Spring Boot 3, Spring Data JPA, MySQL, Maven

🧩 API Endpoints
Method	Endpoint	Description
POST	/api/items	Add food item
GET	/api/items	Get all items
GET	/api/items/restaurant/{id}	Get items by restaurant
PUT	/api/items/{id}	Update item
DELETE	/api/items/{id}	Delete item
