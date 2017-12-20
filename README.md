# sb-local-demo

springboot demo - learning and practice

try it and try it.

### TO-DO 
 1. Put into project: mybatis-generator http://www.cnblogs.com/yjmyzz/p/mybatis-generator-tutorial.html
 2. Unit test cases for Mapper and Controller




reference: http://www.spring4all.com/article/246

#### Tips:
	1. Use Spring Initializr to create spring boot/cloud project
	    New project
	
	2. Create spring boot project manually - gradle init
	
	3. Run: java -jar shyf-api-1.0.0.war Or java -jar xxx.jar --server.port=8089
	    On build.gradle, Configure the Manifest info as bellow: 
        jar {
            manifest {
                attributes(
                        'Class-Path': configurations.compile.collect { it.getName() }.join(' '),
                        'Main-Class': 'com.yf.api.Application'
                )
            }
        }
	
	4. Run on tomcat
        Put the war file to tomcat
        
Next step: 
1. Configure it
2. Mybatis integration


### Spring 集成mybatis 通用mapper
https://github.com/abel533/MyBatis-Spring-Boot

##### 2017-12-20 Fuck!!! 搞了一天, 就因为mapper配置错误. 这个报错也是绝了... 
compile group: 'tk.mybatis', name: 'mapper-spring-boot-starter', version: '1.1.7' //mapper

Add filter
