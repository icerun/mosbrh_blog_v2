#!/usr/bin/env bash

echo '=====开始安装墨上笔如花博客环境====='

echo '=====开始运行mysql====='
docker-compose -f ../yaml/mysql.yml up -d
echo '=====mysql正在进行初始化====='
./wait-for-it.sh localhost:3306 --timeout=60  -- echo "=====mysql已经准备就绪====="

echo '=====开始运行redis====='
docker-compose -f ../yaml/redis.yml up -d

echo '=====开始部署mosbrh_data====='
docker-compose -f ../yaml/mosbrh_data.yml up -d

echo '=====开始部署minio====='
docker-compose -f ../yaml/minio.yml up -d

echo '======================'
echo '=====开始运行后台====='
echo '======================'

echo '=====开始运行mosbrh_go====='
docker-compose -f ../yaml/mosbrh_blog_go.yml up -d

echo '=====开始运行前台====='
echo '======================'

echo '=====开始运行vue_mosbrh_admin====='
docker-compose -f ../yaml/vue_mosbrh_admin.yml up -d


echo '=====开始运行vue_mosbrh_web====='
docker-compose -f ../yaml/vue_mosbrh_web.yml up -d

echo '================================================================='
echo '=====【墨上笔如花博客Go版启动成功】====='
echo '================================================================='
