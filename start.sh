gradle clean build
docker build -t easypoint .
docker run -p 8080:8080 easypoint