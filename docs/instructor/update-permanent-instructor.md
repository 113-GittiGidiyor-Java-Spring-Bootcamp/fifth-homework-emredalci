# Update Permanent Instructor

Update the Permanent Instructor

**URL** : `/api/instructors/update-permanent-instructor`

**Method** : `PUT`

**Request Body**
```json
{
  "address": "İstanbul",
  "fixedSalary": 2000,
  "id": 1,
  "name": "Emre",
  "phoneNumber": "05XXXXXXXXX"
}
```

## Success Response

**Code** : `200 OK`

```json
{
  "name": "Emre",
  "address": "İstanbul",
  "phoneNumber": "05XXXXXXXXX",
  "fixedSalary": 2000,
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