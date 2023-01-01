echo #######################
echo ##### begin copy ######
echo #######################

echo ###### copy mosbrh_admin ########
copy .\conf\prod\mosbrh_admin\application.yml ..\..\mosbrh_admin\src\main\resources\
copy .\conf\prod\mosbrh_admin\bootstrap.yml ..\..\mosbrh_admin\src\main\resources\


echo ###### copy mosbrh_gateway ########
copy .\conf\prod\mosbrh_gateway\application.yml ..\..\mosbrh_gateway\src\main\resources\
copy .\conf\prod\mosbrh_gateway\bootstrap.yml ..\..\mosbrh_gateway\src\main\resources\


echo ###### copy mosbrh_monitor ########
copy .\conf\prod\mosbrh_monitor\application.yml ..\..\mosbrh_monitor\src\main\resources\
copy .\conf\prod\mosbrh_monitor\bootstrap.yml ..\..\mosbrh_monitor\src\main\resources\


echo ###### copy mosbrh_picture ########
copy .\conf\prod\mosbrh_picture\application.yml ..\..\mosbrh_picture\src\main\resources\
copy .\conf\prod\mosbrh_picture\bootstrap.yml ..\..\mosbrh_picture\src\main\resources\


echo ###### copy mosbrh_search ########
copy .\conf\prod\mosbrh_search\application.yml ..\..\mosbrh_search\src\main\resources\
copy .\conf\prod\mosbrh_search\bootstrap.yml ..\..\mosbrh_search\src\main\resources\


echo ###### copy mosbrh_sms ########
copy .\conf\prod\mosbrh_sms\application.yml ..\..\mosbrh_sms\src\main\resources\
copy .\conf\prod\mosbrh_sms\bootstrap.yml ..\..\mosbrh_sms\src\main\resources\


echo ###### copy mosbrh_spider ########
copy .\conf\prod\mosbrh_spider\application.yml ..\..\mosbrh_spider\src\main\resources\
copy .\conf\prod\mosbrh_spider\bootstrap.yml ..\..\mosbrh_spider\src\main\resources\


echo ###### copy mosbrh_web ########
copy .\conf\prod\mosbrh_web\application.yml ..\..\mosbrh_web\src\main\resources\
copy .\conf\prod\mosbrh_web\bootstrap.yml ..\..\mosbrh_web\src\main\resources\
