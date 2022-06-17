# Endpoints

|Method| Endpoint      | Description |
|------| ------------- |------------ |         
|**GET**| localhost:2222/coupons/{couponId} | Get One coupon |  
|**GET**| localhost:2222/coupons | Get all coupons   |
|**POST**| localhost:2222/coupons | Insert a coupon  |
|**PUT**| localhost:2222/coupons/{couponId} | Update a coupon |  
|**DELETE**| localhost:2222/coupons/{couponId} | Delete a coupon  |
|**GET**| localhost:2222/coupons/date/{couponExpiry} | Get coupon for that date   |**GET**| localhost:2222/coupons/code/{couponCode} | Check for coupon offer  |

> server.port = 2222 (can be changed)

<h2><i>Update : 15-06-2022</i></h2>
<br>

**Added Data transfer objects class to the files

**Implemented Model Mapping in Service Class and Response entity in controller

**Screenshots are added under '/src/main/java/resources/screenshots'**

<h2><i>Update : 16-06-2022</i></h2>
<br>

**Queries and Pagination added

<h2><i>Update : 17-06-2022</i></h2>
<br>

**Actuators
**Created a jar and a war file
**Tested the war file on external tomcat
