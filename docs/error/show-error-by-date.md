# Show Error Order By Created Date

Represent all errors by created date

**URL** : `/api/errors/order-by-created-date`

**Method** : `GET`

---

## Success Response

**Code** : `200 OK`

**Sample Response** :

```json
[
  {
    "status": 400,
    "message": "Student age is not valid",
    "createdDate": "2021-09-05T15:57:05.637Z"
  },
  {
    "status": 404,
    "message": "Entity is not found!",
    "createdDate": "2021-09-05T15:56:46.817Z"
  }
]
```