# Show Courses

Represent all courses

**URL** : `/api/courses/find-all`

**Method** : `GET`

---

## Success Response

**Code** : `200 OK`

**Sample Response** :

```json
[
  {
    "courseCode": "CS101",
    "courseName": "Introduction the Computer Science",
    "creditScore": 4,
    "instructorId": 1,
    "studentIds": [
      1
    ]
  }
]
```