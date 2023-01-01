#!/usr/bin/env bash

echo '=====开始关闭墨上笔如花博客环境====='

echo '=====开始关闭mysql====='
docker-compose -f ../yaml/mysql.yml down

echo '=====开始关闭redis====='
docker-compose -f ../yaml/redis.yml down

echo '=====开始关闭mosbrh_data====='
docker-compose -f ../yaml/mosbrh_data.yml down

echo '=====开始关闭minio====='
docker-compose -f ../yaml/minio.yml down

echo '======================'
echo '=====开始关闭后台====='
echo '======================'

echo '=====开始关闭mosbrh_go====='
docker-compose -f ../yaml/mosbrh_blog_go.yml down

echo '=====开始关闭前台====='
echo '======================'

echo '=====开始关闭vue_mosbrh_admin====='
docker-compose -f ../yaml/vue_mosbrh_admin.yml down


echo '=====开始关闭vue_mosbrh_web====='
docker-compose -f ../yaml/vue_mosbrh_web.yml down

echo '================================================================='
echo '=====【墨上笔如花博客Go版关闭成功】====='
echo '================================================================='
