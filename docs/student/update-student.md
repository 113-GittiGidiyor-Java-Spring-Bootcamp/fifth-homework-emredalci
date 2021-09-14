# Update the Student

Updates the Student

**URL** : `/api/students/update-student`

**Method** : `PUT`

**Request Body**
```json
{
  "address": "Istanbul",
  "birthDate": "2000-01-02",
  "gender": "MALE",
  "id": 1,
  "name": "Ahmet"
}
```

## Success Response

**Code** : `200 OK`

```json
{
  "name": "Ahmet",
  "birthDate": "2000-01-02",
  "address": "Istanbul",
  "gender": "MALE",
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