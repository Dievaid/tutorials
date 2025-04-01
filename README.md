In the *app* directory run
```
docker compose up -d
```

Reach http://localhost:8080
Login with the credentials:
  - username: root
  - password: password
  - database: database

Click on "SQL Command" and input the following command
```
create database todo;
```

Now you can press the run button in AppApplication class to run the backend.

Download **Postman** and import this collection so you can test the backend
[Test TODO.postman_collection.json](https://github.com/user-attachments/files/19547703/Test.TODO.postman_collection.json)


In the *frontend* directory run
```
npm install
```

To run the frontend application run
```
npm run dev
```
