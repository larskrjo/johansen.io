#!/bin/bash

username=null
password=null

while read line
  do
    username=$line
  done < $1

while read line
  do
    password=$line
  done < $2

mysql -h localhost --user=$username --password=$password < ~/larskristian.net/larskristian.net/database/migration/prod/baseline.sql
mysql -h localhost --user=$username --password=$password < ~/larskristian.net/larskristian.net/database/migration/test/baseline.sql
