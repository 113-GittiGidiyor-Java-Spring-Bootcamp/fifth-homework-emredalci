# Save Permanent Instructor

Save a new Permanent Istructor

**URL** : `/api/instructors/save-permanent-instructor`

**Method** : `POST`

**Sample Request**

```json
{
  "address": "İstanbul",
  "fixedSalary": 1000,
  "name": "Emre",
  "phoneNumber": "05XXXXXXXXX"
}
```
---
## Success Response

**Code** : `200 OK`

**Response** :

```json
{
  "name": "Emre",
  "address": "İstanbul",
  "phoneNumber": "05XXXXXXXXX",
  "fixedSalary": 1000,
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