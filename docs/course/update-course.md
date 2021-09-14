# Update Course

Updates the Course

**URL** : `/api/courses/update`

**Method** : `PUT`

**Request Body**
```json
{
  "courseCode": "UpdateCourseCode",
  "courseName": "UpdateCourseName",
  "creditScore": 4,
  "instructorId": 1,
  "studentIds": [
    1
  ],
  "id": 1
}
```

## Success Response

**Code** : `200 OK`

```json
{
  "courseCode": "UpdateCourseCode",
  "courseName": "UpdateCourseName",
  "creditScore": 4,
  "instructorId": 1,
  "studentIds": [
    1
  ],
  "id": 1
}
```

## Error Response

**Code** : `404 NOT FOUND`

```json
{
  "id": 1,
  "status": 404,
  "message": "Entity is not found!"
}
```

