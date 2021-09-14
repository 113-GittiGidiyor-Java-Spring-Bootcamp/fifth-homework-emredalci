# Save Visiting Researcher

Save a new Visiting Researcher

**URL** : `/api/instructors/save-visiting-researcher`

**Method** : `POST`

**Sample Request**

```json
{
  "address": "İstanbul",
  "hourlySalary": 100,
  "name": "Mehmet",
  "phoneNumber": "05XXXXXXXXX"
}
```
---
## Success Response

**Code** : `200 OK`

**Response** :

```json
{
  "name": "Mehmet",
  "address": "İstanbul",
  "phoneNumber": "05XXXXXXXXX",
  "hourlySalary": 100,
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