# 📌프로젝트 소개
* DB 쓰기 작업 및 알람 발송을 카프카를 사용하지 않고, 동기적으로 처리
* k6를 사용하여 50명이 1초마다 API 요청하도록 과부하 테스트
* 알람 발송은 실제로 하지 않고 Thread.sleep(1000) 처리

## 🚀실행 방법
1. 터미널에서 코드 다운로드
   ```bash
   git clone https://github.com/nonkafka-vs-kafka-k6-test/non-kafka-sync.git
   ```
   
2. application.yaml파일에 본인의 DB정보 입력
3. powershell 혹은 cmd를 관리자 권한으로 열고 k6 설치
   ```bash
   choco install k6
   ```
4. 애플리케이션 실행
5. 터미널에서 프로젝트 경로로 이동 후 k6테스트 시작
   ```bash
   k6 run test.js
   ```

## 📊k6 과부하 테스트 결과
```text
         /\      Grafana   /‾‾/  
    /\  /  \     |\  __   /  /   
   /  \/    \    | |/ /  /   ‾‾\ 
  /          \   |   (  |  (‾)  |
 / __________ \  |_|\_\  \_____/ 
     execution: local
        script: test.js
        output: -
     scenarios: (100.00%) 1 scenario, 50 max VUs, 1m0s max duration (incl. graceful stop):
              * default: 50 looping VUs for 30s (gracefulStop: 30s)



  █ TOTAL RESULTS 

    checks_total.......: 320     9.257382/s
    checks_succeeded...: 100.00% 320 out of 320
    checks_failed......: 0.00%   0 out of 320

    ✓ status is 200

    HTTP
    http_req_duration..............: avg=4.06s min=1.01s med=4.17s max=7.3s  p(90)=4.29s p(95)=4.46s
      { expected_response:true }...: avg=4.06s min=1.01s med=4.17s max=7.3s  p(90)=4.29s p(95)=4.46s
    http_req_failed................: 0.00% 0 out of 320
    http_reqs......................: 320   9.257382/s

    EXECUTION
    iteration_duration.............: avg=5.07s min=2.02s med=5.19s max=8.31s p(90)=5.31s p(95)=5.47s
    iterations.....................: 320   9.257382/s
    vus............................: 10    min=10       max=50
    vus_max........................: 50    min=50       max=50

    NETWORK
    data_received..................: 58 kB 1.7 kB/s
    data_sent......................: 53 kB 1.5 kB/s




running (0m34.6s), 00/50 VUs, 320 complete and 0 interrupted iterations
default ✓ [======================================] 50 VUs  30s
```

