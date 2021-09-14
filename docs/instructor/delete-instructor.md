# Delete the instructor

**URL** : `/api/instructors/delete-by-id`

**URL Parameters** : `id=[long]`

**Method** : `DELETE`

---

## Success Response

**Code** : `200 OK`

## Error Response

**Code** : `404 NOT FOUND`

**Response** :

```json
{
  "id": 1,
  "status": 404,
  "message": "Entity is not found!"
}
```