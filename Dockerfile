FROM ubuntu:latest
LABEL authors="stuart"

ENTRYPOINT ["top", "-b"]
