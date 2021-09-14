# Show Error By Status Code

Show all errors by status code

**URL** : `/api/errors/find-all-by-status`

**URL Parameters** : `id=[int]`

**Method** : `GET`

---

## Success Response

**Code** : `200 OK`

**Response** :

```json
[
  {
    "status": 400,
    "message": "Student age is not valid",
    "createdDate": "2021-09-05T15:57:05.637Z"
  }
]
```