# Spring_boot blog

숭실대학교 소프트웨어학부 18학번 채예진

## 회원가입 및 로그인
### Registration
- http://127.0.0.1:8000/user/registration
<img width="1010" alt="스크린샷 2021-03-06 오후 11 25 03" src="https://user-images.githubusercontent.com/45252618/110210306-65bd3f80-7ed4-11eb-8a44-41f374ef8a07.png">

### Login
- http://127.0.0.1:8000/user/login
  
- 로그인 성공
<img width="1009" alt="스크린샷 2021-03-06 오후 11 25 16" src="https://user-images.githubusercontent.com/45252618/110210315-6b1a8a00-7ed4-11eb-9d52-dcf2cc31a08d.png">


- 로그인 실패 (회원 정보 없음)
  <img width="1011" alt="스크린샷 2021-03-06 오후 10 41 59" src="https://user-images.githubusercontent.com/45252618/110208973-5a1a4a80-7ecd-11eb-9310-2fe54ae46a37.png">


- 로그인 실패 (잘못된 비밀번호)
  <img width="1010" alt="스크린샷 2021-03-06 오후 10 42 16" src="https://user-images.githubusercontent.com/45252618/110208968-54bd0000-7ecd-11eb-8256-ba73a3077b71.png">

  
## Blog CRUD
### Create
- http://127.0.0.1:8000/blog
- 글 생성 성공
  <img width="1011" alt="스크린샷 2021-03-06 오후 11 29 40" src="https://user-images.githubusercontent.com/45252618/110210317-6d7ce400-7ed4-11eb-8170-f2bec37ef190.png">


- 글 생성 실패 (로그인 안함)
<img width="1008" alt="스크린샷 2021-03-05 오후 6 55 26" src="https://user-images.githubusercontent.com/45252618/110101401-d38b3d80-7de6-11eb-8230-7c0d3bc151eb.png">

### Read
#### 글 전체 조회
- http://127.0.0.1:8000/blog
<img width="1010" alt="스크린샷 2021-03-06 오후 11 30 46" src="https://user-images.githubusercontent.com/45252618/110210318-6e157a80-7ed4-11eb-86a6-d1d51b9f00db.png">

#### 글 하나 조회
- http://127.0.0.1:8000/blog/{id}
<img width="1009" alt="스크린샷 2021-03-06 오후 11 31 15" src="https://user-images.githubusercontent.com/45252618/110210319-6eae1100-7ed4-11eb-92d0-23e0389ce785.png">

### Update
- http://127.0.0.1:8000/blog/{id}
- 글 수정 성공
  <img width="1008" alt="스크린샷 2021-03-06 오후 11 31 54" src="https://user-images.githubusercontent.com/45252618/110210310-67870300-7ed4-11eb-8b4f-435bd9b5d948.png">
  
  
- 글 수정 실패 (로그인 안함)
<img width="1010" alt="스크린샷 2021-03-05 오후 6 56 37" src="https://user-images.githubusercontent.com/45252618/110101412-d6862e00-7de6-11eb-9bd1-c6b01c01f225.png">


- 글 수정 실패 (회원 불일치)
  <img width="1013" alt="스크린샷 2021-03-05 오후 7 21 19" src="https://user-images.githubusercontent.com/45252618/110208856-cf395000-7ecc-11eb-8638-a858c7d41c5c.png">
  

### Delete
- http://127.0.0.1:8000/blog/{id}
- 글 삭제 성공
<img width="1014" alt="스크린샷 2021-03-06 오후 11 39 39" src="https://user-images.githubusercontent.com/45252618/110210496-4672e200-7ed5-11eb-99e4-0ec5c137028b.png">


- 글 삭제 실패 (글 정보 없음)
  <img width="1008" alt="스크린샷 2021-03-06 오후 11 39 18" src="https://user-images.githubusercontent.com/45252618/110210493-45da4b80-7ed5-11eb-9d20-f83203e763f9.png">


개발툴 : Intellij

데이터베이스 : MySQL

테스트툴 : Postman
