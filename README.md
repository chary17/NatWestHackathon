# NatWestHackathon
RestApi to post data into H2Database(Temperory).
---------------------------Build project------------------------------
Clone the spring Boot project into local
1. open it in your eclipse IDE
2. Run **NatwestHackathonApplication.java** file as Java Application from IDE
3. Apllication will be running on port 8082 of localhost -- (can be changed in application.properties)
4. Perform a POST request from POSTMAN/SOAP UI --- giving URL http://localhost:8082/transaction
5. And providing body to the request.
6. The request is being sent back as response in encrypted format.
7. decrypted data is stored in H2 DB.
------------------------Opening H2 db console-----------------------------
1. Open browser with URL http://localhost:8082/h2-console/
2. Give required feilds DB URL, UserName , Password from application.properties.
3. select * from the table TRANSACTION_ENTITY
4. Then the added data will be visible in the results.


Git Hub URL : https://github.com/chary17/NatWestHackathon
