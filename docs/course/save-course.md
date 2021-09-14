# Save Course

Save a new Course

**URL** : `/api/courses/save-course`

**Method** : `POST`

**Sample Request**

```json
{
  "courseCode": "CS101",
  "courseName": "Introduction the Computer Science",
  "creditScore": 4,
  "instructorId": 1,
  "studentIds": [
    1
  ]
}
```
---
## Success Response

**Code** : `201 CREATED`

**Response** :

```json
{
  "courseCode": "CS101",
  "courseName": "Introduction the Computer Science",
  "creditScore": 4,
  "instructorId": 1,
  "studentIds": [1],
  "id": 1
}
```
---
## Error Response

**Code** : `400 BAD REQUEST`

**Response** : 

```json
{
  "id": 1,
  "status": 400,
  "message": "Entity is already exist!"
}
```