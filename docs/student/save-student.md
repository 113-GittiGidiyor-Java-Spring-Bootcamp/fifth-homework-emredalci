# Save a Student

Save a new Student

**URL** : `/api/students/save-student`

**Method** : `POST`

**Sample Request**

```json
{
  "address": "Istanbul",
  "birthDate": "2000-01-01",
  "gender": "MALE",
  "name": "Ahmet"
}
```
---
## Success Response

**Code** : `200 OK`

**Response** :

```json
{
  "name": "Ahmet",
  "birthDate": "2000-01-01",
  "address": "Istanbul",
  "gender": "MALE",
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

**Code** : `400 BAD REQUEST`

**Response** :

```json
{
  "id": 2,
  "status": 400,
  "message": "Student age is not valid"
}
```