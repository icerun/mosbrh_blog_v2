#!/usr/bin/env bash

echo '=====开始结束运行墨上笔如花博客服务====='

echo '=====结束运行portainer可视化工具====='
docker-compose -f ../yaml/portainer.yml down

echo '=====结束运行mysql====='
docker-compose -f ../yaml/mysql.yml down

echo '=====结束运行nacos====='
docker-compose -f ../yaml/nacos.yml down

echo '=====结束运行rabbitmq====='
docker-compose -f ../yaml/rabbitmq.yml down

echo '=====结束运行redis====='
docker-compose -f ../yaml/redis.yml down

echo '=====结束运行mosbrh_data====='
docker-compose -f ../yaml/mosbrh_data.yml down

echo '=====结束运行minio====='
docker-compose -f ../yaml/minio.yml down


echo '=========================='
echo '=====结束后台服务运行====='
echo '=========================='

echo '=====结束运行mosbrh_gateway====='
docker-compose -f ../yaml/mosbrh_gateway.yml down

echo '=====结束运行mosbrh_admin====='
docker-compose -f ../yaml/mosbrh_admin.yml down

echo '=====结束运行mosbrh_picture====='
docker-compose -f ../yaml/mosbrh_picture.yml down

echo '=====结束运行mosbrh_sms====='
docker-compose -f ../yaml/mosbrh_sms.yml down

echo '=====结束运行mosbrh_web====='
docker-compose -f ../yaml/mosbrh_web.yml down


echo '=========================='
echo '=====结束前台服务运行====='
echo '=========================='

echo '=====结束运行vue_mosbrh_admin====='
docker-compose -f ../yaml/vue_mosbrh_admin.yml down


echo '=====结束运行vue_mosbrh_web====='
docker-compose -f ../yaml/vue_mosbrh_web.yml down

echo '=============================='
echo '=====所有服务已经结束运行====='
echo '=============================='