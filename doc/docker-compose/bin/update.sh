#!/usr/bin/env bash

echo '=====开始更新墨上笔如花博客镜像====='

echo '=====开始关闭运行的容器====='
sh kernShutdown.sh

echo '=====开始更新mosbrh-gateway====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/mosbrh_gateway

echo '=====开始更新mosbrh-admin====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/mosbrh_admin

echo '=====开始更新mosbrh-web====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/mosbrh_web

echo '=====开始更新mosbrh-sms====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/mosbrh_sms

echo '=====开始更新mosbrh-picture====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/mosbrh_picture

echo '=====开始更新vue_mosbrh_admin====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/vue_mosbrh_admin

echo '=====开始更新vue_mosbrh_web====='
docker pull registry.cn-shenzhen.aliyuncs.com/mosbrhblog/vue_mosbrh_web

echo '=====删除docker标签为none的镜像====='
docker images | grep none | awk '{print $3}' | xargs docker rmi

echo '=====开始运行的一键部署脚本====='
sh kernStartup.sh
