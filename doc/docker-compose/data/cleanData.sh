#!/usr/bin/env bash

cd "$(dirname "$0")" || exit

echo '=====进入数据目录====='
echo "$PWD"

echo '=====开始清空博客中的数据====='
echo '=====开始清空minio====='
rm -rf ./minio_data/*

echo '=====开始清空mosbrh_data数据====='
#rm -rf ./mosbrh_data/*

echo '=====开始清空mysql数据====='
rm -rf ./mysql_data/*

echo '=====开始清空portainer数据====='
rm -rf ./portainer/data/*

echo '=====开始清空rabbitmq数据====='
rm -rf ./rabbitmq_data/*

echo '=====开始清空redis数据====='
rm -rf ./redis_data/*

echo '=====开始清空elk数据====='
rm -rf ./elasticsearch_data/*

echo '=====开始清空logstash数据====='
rm -rf ./logstash/*

echo '=====开始清空log日志====='
rm -rf ../log/*

echo '=============================='
echo '=====所有数据已经被清空======='
echo '=============================='
