# Проект для проверки работы Amazon S3

Хранилище используется для этой задачи
Yandex cloud

## How to create image on Docker

1. Maven lifecycle click on 'clean'
2. Maven lifecycle click on 'install'
3. Enter command:
```bash
docker build -t imageserver:0.1 .
```
or
```bash
docker pull betrayal96/imageserver:0.1
```


Run docker container:
```bash
docker run -p 8081:8081 -d --name image-server imageserver:0.1
```
or
```bash
docker compose up -d
```