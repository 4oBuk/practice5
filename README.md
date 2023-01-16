# How to run?
1. open project's root directory in the terminal
2. run `docker-compose up -d` in terminal to create test and dev databases.(ports 3306 and 3307 will be used)
docker-compose uses sql scripts in `sql` folder to create tables and add data.
3. run application or tests (test for deleting an illustration passes only once because entity will be deleted from test-db after fist run)