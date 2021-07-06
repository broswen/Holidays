FROM openjdk:11 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew build

FROM openjdk:11
COPY --from=builder --chown=1000:1000 /app/build/libs/holiday-*.jar holiday.jar
USER 1000
EXPOSE 8080
CMD ["java", "-jar", "holiday.jar"]