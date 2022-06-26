::7-zip��ѹ
@echo off
set localFolder=E:\dx\hw\192.168.94.1
set localmro=E:\dxmro\hw
title dechw133
if exist %localmro% (
echo Ŀ¼%localmro%���ڣ����贴��
) else (
md %localmro%
)
for /r %localFolder% %%p in (*HUAWEI*.tar.gz) do (
7z e %%p -o%%~dp%%~pp%%~np -r -y
7z e %%~dp%%~pp%%~np *MRO*.gz -o%%~dp%%~pp%%~np -r -y
7z e %%~dp%%~pp%%~np\*MRO*.gz -o%localmro% -r -y
)
for /r %localFolder% %%i in (*HUAWEI*.tar.gz *.tmp *MRO*.gz *MRE*.gz *MRS*.gz) do if exist %%i del %%i
for /f "tokens=*" %%a in ('dir /b /ad /s %localFolder%^|sort /r') do rd "%%a" /q 2>nul
exit