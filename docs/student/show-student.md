# Show Student

Represent student by name

**URL** : `/api/students/find-by-name`

**Parameters** : `name=[String]`

**Method** : `GET`

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

**Code** : `404 NOT FOUND`

**Response**

```json
{
  "id": 1,
  "status": 404,
  "message": "Entity is not found!"
}
```