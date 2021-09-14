# Show Instructor

Represent instructor by name

**URL** : `/api/instructor/find-by-name`

**Parameters** : `name=[String]`

**Method** : `GET`

---

## Success Response

**Code** : `200 OK`

**Response** :

```json
{
  "name": "Emre",
  "address": "İstanbul",
  "phoneNumber": "05XXXXXXXXX",
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