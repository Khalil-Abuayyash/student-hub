# student-hub






## Our mission and vision:
student-hub is a platform built for students from different universities to share and exchange their knowledge, each student will be able to see how each course is being taught in other universities, to discuss problems and solutions, to download lecture notes and videos.


## Technologies Used
1- Visual Studio Code
2- Spring Tool Suite 4
3-bootstrap - version 3.0/ 4.0
4-jQuery and AJAX


## Functional Requirements:
User Authentication And Authorization:
The system shall display a registration form in the login page to register if the user doesn’t already have an account.
The system shall allow the user login using his email and password.
The system shall allow the user to change his email or his password in his profile or any other information in the user profile.
The system shall send a confirmation email to the user after successful registration or a successful email change. (API) (Backlog)
The system shall allow the user to rewrite the password if the user forgets his password through sending him an email to change his password.(API) (Backlog)`
The system shall restrict the user - depending on the role of the user - from accessing the wrong data or functions. (More details) (User and Admin).

Provide Dashboard (No added courses)
The system shall display all the colleges that the admin added to the system.
The system shall allow the user to select a college to see all of  its departments.
The system shall display all the departments that the admin added to the system.
The system shall allow the user to select a departement to see all of  its courses.
The system shall display all the courses that the admin added to the system.
The system shall allow the user to add a course to his/her courses.

		Provide Dashboard (there is at least one added course)
The system shall display all the user’s courses.
The system shall allow the user to select a course to see all of  its information.
The system shall allow the user to add more courses  and delete selected ones.


		Provide Course Profile
The system shall allow the user to download lecture notes and  lecture videos, course outline.
The system shall display a wall containing other students’ posts and comments.
The system shall allow the user to add posts and comments to the wall.
The system shall allow the user to edit his own posts and comments.
The system shall allow the user to delete his own posts and comments.

Non-Functional Requirements
Usability
Graphical User Interface
● The system shall provide a uniform look and feel between all the web pages.
● The system shall provide a dark mode theme.
● The system shall provide use of icons and toolbars.
Accessibility
● The system shall provide multi language support.
● The Student-hub system shall allow users to perform their intentions in a simple way.
Ease of use
● The students shall be able to use DenTaChx features without any difficulties.
● The Student-hub shall be easy to learn for both novices and users with experience from similar systems.
● The Student-hub shall be easy to remember for the casual user.
● The user must understand what the system does.
Reliability and Availability
Performance
● The system shall be based on the web and has to be run from a web server.
● The system shall take initial load time depending on internet connection strength which also depends on the media from which the product is run.
● The performance shall depend upon hardware components of the
client/customer.
● The response times shall be less than 2 seconds or less, over a 16 megabits/second Internet connection, 90% of the time.
● The shall load no less than 1000 user operations at the same time.

Security
	Spring Security will be used.



Data Transfer
● The system shall automatically log out all users after a period of
inactivity.
● The system shall confirm all transactions with the user’s web browser.
● The system shall not leave any cookies on the user’s computer
containing the user’s password.
● The system shall not leave any cookies on the user’s computer containing any of the user’s confidential information.
● The system shall protect data against vulnerabilities, such as SQL injection attacks.
Data Storage
● The user’s web browser shall never display a user’s password. It shall always be displayed with special characters representing password typed characters.
● The system’s back-end servers shall never display a user’s password. The user’s password may be reset but never shown.
● The system’s back-end servers shall only be accessible to authenticated administrators.
● The system’s back-end databases shall be encrypted.

Maintainability
● MySQL is used for maintaining the database and the Cloud server takes care of the site. In case of a failure, a re-initialization of the program is recommended.

Design Constraints
Web Based Product
● There are no memory requirements.
● The computers must be equipped with web browsers such as Internet explorer.
● The product must be stored in such a way that allows the client easy access to it.
● Response time for loading the system should take no longer than 2 minutes.
● A general knowledge of basic computer skills is required to use the product.

Interfaces

There are many types of interfaces as such supported by the software system namely; User
Interface, Software Interface and Hardware Interface.
The protocol used shall be HTTP.
The Port number used will be 80.

