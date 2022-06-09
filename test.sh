curl -X POST -H "User-Agent: linux bla bla" -H "Content-Type: application/json" -d " \
{\
\"servicenm\":\"알림봇\",\
\"groupid\":\"100001\",\
\"date\":\"20220512223000\",\
\"msg\":\"알림 봇 서비스 테스트\",\
\"type\":\"1\"\
}" localhost:8080/v1/telegram