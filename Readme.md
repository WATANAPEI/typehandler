
## initialize with curl
curl -s https://start.spring.io/starter.tgz \
-d bootVersion=3.0.2 \
-d javaVersion=17 \
-d type=gradle-project \
-d groupId=dev.wpei \
-d artifactId=typehandler \
-d name=typehandler \
-d version=0.0.1-SNAPSHOT \
-d packageName=dev.wpei.typehandler \
-d dependencies=lombok,web,mybatis,flyway,mysql,validation,devtools,configuration-processor,actuator | tar zxvf -
