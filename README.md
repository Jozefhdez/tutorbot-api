# Mini TutorBot API

This is a Spring Boot REST API for a campus tutoring system.

## How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Wait for Maven dependencies to load.
4. Run `TutorbotApplication.java`.
5. The server will start on `http://localhost:8080`.

## API Endpoints

### Students
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | `/api/students` | List all students |
| GET | `/api/students/{id}` | Get student by ID (Returns 404 if not found) |
| POST | `/api/students` | Register a new student |
| GET | `/api/students/{id}/feedback` | **Bonus:** View submission history |

### Exercises
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | `/api/exercises` | List all exercises |
| GET | `/api/exercises?difficulty={val}` | Filter exercises by level |
| POST | `/api/exercises/submit` | Submit an answer and get a score |

## Postman Screenshots
Below are the results of the API tests.

### 1. GET All Students
![GET Students](/screenshots/get_all_students.png)

### 2. GET Student by ID
![GET Student ID](/screenshots/get_student_id.png)

### 3. POST Register Student
![POST Student](/screenshots/post_student.png)

### 4. GET All Exercises
![GET Exercises](/screenshots/get_exercises.png)

### 5. GET Exercises by Difficulty
![GET Difficulty](/screenshots/get_difficulty.png)

### 6. POST Submit Answer (Correct)
![POST Submit Correct](/screenshots/submit_correct.png)

### 7. POST Submit Answer (Wrong)
![POST Submit Wrong](/screenshots/submit_wrong.png)

### 8. GET Student Feedback History
![GET Feedback](/screenshots/get_feedback.png)