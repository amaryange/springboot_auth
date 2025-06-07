FROM ubuntu:latest
LABEL authors="applecenter"

ENTRYPOINT ["top", "-b"]
