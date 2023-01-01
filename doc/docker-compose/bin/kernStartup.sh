#!/usr/bin/env bash

echo '=====开始安装墨上笔如花博客环境====='

echo '=====开始运行mysql====='
docker-compose -f ../yaml/mysql.yml up -d
echo '=====mysql正在进行初始化====='
./wait-for-it.sh localhost:3306 --timeout=60  -- echo "=====mysql已经准备就绪====="

echo '=====开始部署portainer可视化工具====='
#docker-compose -f ../yaml/portainer.yml up -d

echo '=====开始运行nacos====='
docker-compose -f ../yaml/nacos.yml up -d
echo '=====nacos正在进行初始化,请等待...====='
./wait-for-it.sh localhost:8848 --timeout=60  -- echo "=====nacos已经准备就绪====="

echo '=====开始运行rabbitmq====='
docker-compose -f ../yaml/rabbitmq.yml up -d

echo '=====开始运行redis====='
docker-compose -f ../yaml/redis.yml up -d

echo '=====开始部署mosbrh_data====='
docker-compose -f ../yaml/mosbrh_data.yml up -d


echo '======================'
echo '=====开始运行后台====='
echo '======================'

echo '=====开始运行mosbrh_gateway====='
docker-compose -f ../yaml/mosbrh_gateway.yml up -d

echo '=====开始运行mosbrh_admin====='
docker-compose -f ../yaml/mosbrh_admin.yml up -d

echo '=====开始运行mosbrh_picture====='
docker-compose -f ../yaml/mosbrh_picture.yml up -d

echo '=====开始运行mosbrh_sms====='
docker-compose -f ../yaml/mosbrh_sms.yml up -d

echo '=====开始运行mosbrh_web====='
docker-compose -f ../yaml/mosbrh_web.yml up -d

echo '执行完成 日志目录: ./log'


echo '======================'
echo '=====开始运行前台====='
echo '======================'

echo '=====开始运行vue_mosbrh_admin====='
docker-compose -f ../yaml/vue_mosbrh_admin.yml up -d


echo '=====开始运行vue_mosbrh_web====='
docker-compose -f ../yaml/vue_mosbrh_web.yml up -d

echo '================================================================='
echo '=====【微服务启动需要耗费一定时间，请到Nacos中查看启动情况】====='
echo '================================================================='
