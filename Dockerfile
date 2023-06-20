FROM eclipse-temurin:17.0.7_7-jdk-jammy@sha256:b44dfb46bc455a4996762a65c97a5e1d0f8c71ad5139482003a1b34877518b72 as connector-basic-image
RUN addgroup --system spring && adduser --system spring --ingroup spring
RUN mkdir /rof  && mkdir /rof/config && chown spring:spring /rof -R
FROM connector-basic-image as default
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /rof/app.jar
EXPOSE 8080 33000
VOLUME /rof/config
WORKDIR /rof
ENTRYPOINT ["java","-jar","/rof/app.jar"]