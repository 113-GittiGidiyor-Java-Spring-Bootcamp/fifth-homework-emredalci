# Update Visiting Researcher

Update the Visiting Researcher

**URL** : `/api/instructors/update-visiting-researcher`

**Method** : `PUT`

**Request Body**
```json
{
  "address": "İstanbul",
  "hourlySalary": 200,
  "id": 1,
  "name": "Mehmet Veli",
  "phoneNumber": "05XXXXXXXX2"
}
```

## Success Response

**Code** : `200 OK`

```json
{
  "name": "Mehmet Veli",
  "address": "İstanbul",
  "phoneNumber": "05XXXXXXXX2",
  "hourlySalary": 200,
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