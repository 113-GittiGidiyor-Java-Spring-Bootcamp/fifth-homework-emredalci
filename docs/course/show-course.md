# Show Courses

Represent courses by name

**URL** : `/api/courses/find-by-name`

**Parameters** : `name=[String]`

**Method** : `GET`

---

## Success Response

**Code** : `200 OK`

**Response** :

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
## Error Response

**Code** : `404 NOT FOUND`

**Response**

```json
{
  "id": 1,
  "status": 404,
  "message": "Entity is not found!"
}
```