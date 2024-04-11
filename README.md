# Academic Simulator Using MVC Framework  

***
### `What is MVC?`
MVC (Model View Controller) framework is an architectural/design pattern that separates an application into three main logical components Model, View, and Controller. Each architectural component is built to handle specific development aspects of an application. It isolates the business logic and presentation layer from each other. 

### `Feature Overview`
This academic simulator, developed using the MVC framework, encompasses several key features to manage academic operations effectively.

### 1. Lecturer Management ('lecturer-add')
This feature allows the addition of new lecturers into the system. With this functionality, administrators can easily onboard new teaching staff, ensuring a seamless integration process.

### 2. Student Management ('student-add')
The student management feature facilitates the addition of new students to the academic system. It streamlines the enrollment process and ensures accurate student data management for administrative purposes.

### 3. Course Management ('course-add')
The course management feature enables administrators to add new courses to the academic curriculum. It provides flexibility in adapting to changing educational requirements and ensures comprehensive course offerings for students.

### 4. Enrollment Management ('enrollment-add')
This functionality allows for the enrollment of students in various courses. It ensures efficient allocation of students to their desired courses, optimizing the academic experience for each individual.

### 5. Grade Management ('enrollment-grade')
The grade management feature facilitates the recording and management of student grades. It provides educators with valuable insights into student performance and supports effective academic assessment practices.

### 6. Student Details ('student-details')
This feature enables the retrieval of detailed information about individual students. It offers administrators and educators comprehensive insights into student profiles, facilitating personalized support and academic guidance.

### 7. Remedial Enrollment ('enrollment-remedial')
The remedial enrollment feature allows students to enroll in remedial courses to address academic challenges effectively. It supports students in overcoming academic difficulties and promotes continuous learning and improvement.

### 8. Course Opening ('course-open')
This functionality enables the opening of courses for student enrollment. It ensures timely availability of courses and allows students to plan their academic schedules efficiently.

### 9. Course History ('course-history')
The course history feature provides access to the historical data of courses offered within the academic institution. It supports informed decision-making processes and facilitates the analysis of past academic trends.

***
Let's see the example


**Input**:

```bash
lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
lecturer-add#0124108201#Rosni Lumbantoruan#RSL#rosni@del.ac.id#Information Systems
course-add#12S1101#Dasar Sistem Informasi#3#D
student-add#12S20001#Marcelino Manalu#2020#Information Systems
student-add#12S20002#Yoga Sihombing#2020#Information Systems
student-add#12S20003#Marcel Simanjuntak#2020#Information Systems
course-open#12S1101#2020/2021#odd#IUS
enrollment-add#12S1101#12S20001#2020/2021#odd
enrollment-add#12S1101#12S20002#2020/2021#odd
enrollment-add#12S1101#12S20003#2020/2021#odd
enrollment-grade#12S1101#12S20001#2020/2021#odd#B
enrollment-grade#12S1101#12S20002#2020/2021#odd#B
enrollment-grade#12S1101#12S20003#2020/2021#odd#B
course-open#12S1101#2020/2021#even#IUS
course-open#12S1101#2021/2022#odd#IUS
enrollment-add#12S1101#12S20002#2021/2022#odd
enrollment-add#12S1101#12S20003#2021/2022#odd
enrollment-grade#12S1101#12S20002#2021/2022#odd#C
enrollment-grade#12S1101#12S20003#2021/2022#odd#AB
enrollment-remedial#12S1101#12S20002#2021/2022#odd#B
enrollment-add#12S1101#12S20001#2020/2021#even
enrollment-add#12S1101#12S20002#2020/2021#even
enrollment-add#12S1101#12S20003#2020/2021#even
enrollment-grade#12S1101#12S20001#2020/2021#even#BC
enrollment-grade#12S1101#12S20002#2020/2021#even#A
enrollment-grade#12S1101#12S20003#2020/2021#even#A
enrollment-remedial#12S1101#12S20001#2020/2021#even#AB
course-history#12S1101
---

```

**Output**:

```bash
12S1101|Dasar Sistem Informasi|3|D|2020/2021|odd|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|B
12S1101|12S20003|2020/2021|odd|B
12S1101|Dasar Sistem Informasi|3|D|2021/2022|odd|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20002|2021/2022|odd|B(C)
12S1101|12S20003|2021/2022|odd|AB
12S1101|Dasar Sistem Informasi|3|D|2020/2021|even|IUS (iustisia.simbolon@del.ac.id)
12S1101|12S20001|2020/2021|even|AB(BC)
12S1101|12S20002|2020/2021|even|A
12S1101|12S20003|2020/2021|even|A
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics
0124108201|Rosni Lumbantoruan|RSL|rosni@del.ac.id|Information Systems
12S1101|Dasar Sistem Informasi|3|D
12S20001|Marcelino Manalu|2020|Information Systems
12S20002|Yoga Sihombing|2020|Information Systems
12S20003|Marcel Simanjuntak|2020|Information Systems
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|B
12S1101|12S20003|2020/2021|odd|B
12S1101|12S20002|2021/2022|odd|B(C)
12S1101|12S20003|2021/2022|odd|AB
12S1101|12S20001|2020/2021|even|AB(BC)
12S1101|12S20002|2020/2021|even|A
12S1101|12S20003|2020/2021|even|A

```

