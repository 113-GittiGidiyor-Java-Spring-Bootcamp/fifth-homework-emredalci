# Show Instructor Logger

Represent instructor logger by instructor id

**URL** : `/api/instructor/instructorLoggerByInstructorId`

**Parameters** : `id=[Long]`

**Method** : `GET`

## Success Response

**Code** : `200 OK`

```json
[
  {
    "id": 1,
    "instructorId": 1,
    "clientIpAddress": "0:0:0:0:0:0:0:1",
    "clientUrl": "/api/instructors/update-salary",
    "sessionActivityId": "843157198B8C2E64E0087CF3E94C6A74",
    "createdTime": "2021-09-14",
    "updateSalaryType": "INCREASE",
    "salaryBefore": 1000,
    "salaryAfter": 1500,
    "salaryRate": 50
  }
]
```