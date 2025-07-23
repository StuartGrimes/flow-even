FROM openjdk
LABEL authors="stuart"
WORKDIR /app
COPY . /app
RUN flow-even
CMD ["java", "flow-even"]
