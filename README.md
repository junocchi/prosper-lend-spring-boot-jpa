# Prosper Lend (with Spring Boot JPA)
Final project at Wiley Edge trainee program using Spring Boot JPA. Prosper Lend is a Business Loan Provider that offers exclusive interest rates discounts for companies committed to making a positive impact in the world.

## Group
@catalina-kalman @DominiqueAMWalker @hodanhassan2408 and @junocchi

## Features achieved
The user can:
- [x] Sign up and create an account (we use hashing passwords)
- [x] Log in with a username and password
- [x] See the home page for fintech news
- [x] See their profile page with an avatar photo
- [x] Update their username and email
- [x] Request funding
- [x] See payment history
- [x] See loans and their current status (in progress or complete)
- [x] Message Prosper Lend if they need help
- [x] Log out

## Presentation
At the end of the two weeks, the team presented to the rest of our cohort and instructors detailing our approach, planning, achievements and goals, before giving a live demo of the site. Click the image to access the slides.

<p align="center">
<a href="https://drive.google.com/file/d/15TOZVcwI31lBQp5FsmJnBV7MlGT0epre/view?usp=sharing" target="_blank">
<img width="200" alt="image" src="ProsperLend/src/main/resources/static/images/prosper-logo.png" >
</a>
</p>

## Entity relationship diagrams
<p align="center"><img align="center" height="600" src="sql-and-images/images/ERD diagrams.png"></p>

## Main pages

<p align="center">Login</p>
<p align="center"><img align="center" height="200" src="sql-and-images/images/login-page.png"></p>

<p align="center">Home</p>
<p align="center"><img height="400" src="sql-and-images/images/home.png"></p>

<p align="center">My Profile</p>
<p align="center"><img height="250" src="sql-and-images/images/my-profile.png"></p>

<p align="center">Request Funding</p>
<p align="center"><img height="250" src="sql-and-images/images/request-funding.png"></p>

<p align="center">About Us</p>
<p align="center"><img height="250" src="sql-and-images/images/about-us.png"></p>

## How to try the project

### Setup
1. Clone the repo
2. Install Eclipse and MySQL Workbench
3. Execute prosperLend.sql (to create a local database)
4. Add your spring data sources (driver-class-name, URL, username and password) to application.properties
   
### Running
1. Run ProsperLendApplication.java as Spring Boot App
2. Go to `http://localhost:8080/login-page`
3. To log in as an existing user
- Username: `test_user`
- Password: `password`
