Друга лабораторна робота з предмету ТРСПО.


ManagerService:

GET:

/managers?state=&name=

POST:

/managers?name=&knowEnglish=

DELETE:

/managers?name=

ClientService:

GET:

/clients?name=&state=

POST:

/clients?language=&name=&ClientType

DELETE:

/clients?name=

GuideService: 
GET: /repairs?state=&name=

POST: /repairs?knowEnglish=&name=

DELETE: /repairs?name=

PUT: /repairs?name=



ExcursionService 
GET:

/order?state=&name=

POST:

/order?guideName=&day=&month=&visitors=&duration=

DELETE:

/order?state=&name=


GroupService 
GET:

/order?day=&month=&state=

POST:

/order?day=&month=&clientsList=&managerName=

DELETE:

/order?day=&month=
