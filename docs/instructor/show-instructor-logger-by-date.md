# Show Instructor Logger

Represent instructor logger by date

**URL** : `/api/instructor/instructorLoggerByDate`

**Parameters** : `date=[LocalDate]`

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
    "salaryAfter": 1200,
    "salaryRate": 20
  },
  {
    "id": 2,
    "instructorId": 1,
    "clientIpAddress": "0:0:0:0:0:0:0:1",
    "clientUrl": "/api/instructors/update-salary",
    "sessionActivityId": "843157198B8C2E64E0087CF3E94C6A74",
    "createdTime": "2021-09-14",
    "updateSalaryType": "INCREASE",
    "salaryBefore": 1200,
    "salaryAfter": 1320,
    "salaryRate": 10
  }
]
```