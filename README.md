# 论坛管理系统-API

论坛管理系统-API

+ [1.1 tips](## 1.1 tips)
+ [1.2 用户User](## 1.2 用户 User)
  + [1.2.1 登录](1.2.1 登录)
  + [1.2.2 退出登录](### 1.2.2 退出登录)
  + [1.2.3 注册账户](### 注册账户)
  + [1.2.4 修改用户信息](### 修改用户信息)
  + [1.2.5 删除用户](### 删除用户信息)
+ [1.3 回答](## 1.3 回答 Answer)
  + [1.3.1 根据用户id(uid)获取用户所有回答](### 1.3.1 根据用户的id（uid）获取该用户所有的回答)
  + [1.3.2 根据问题id(qid)获取问题下所有回答](### 1.3.2 根据问题的id（qid）获取其所有问题)
  + [1.3.3 ]



## 1.1 tips

* 用户类别：
  + 0 ：未注册用户
  + 1 ：注册后的普通用户
  + 2 ： 管理员
* code：
  + 0 ： 正常
  + 1 ： 出现异常
* data ： 返回的数据
* url ： host + uri
  * example :
    + host : http://182.92.121.195:8080/
    + uri : /login
    + url : http://182.92.121.195:8080/login



## 1.2 用户 User

* 注意事项：

### 1.2.1 登录

* POST /login

* payload ：

  ```json
  {
      "userId" : "u1",
      "userPassword" : "123456"
  }
  ```

* return ： 

  ```json
  {
  	"code" : 0,
  	"data" : {
  		"userId":"u1",
          "type":1,
          "token":"2dfdg332131232cvdfd23123jl"
  	}
  }
  ```

* 登录获得token，在每个接口中都要用到，把token设置到request header中



### 1.2.2 退出登录

* POST /exit/{id}

* return: 

  ```json
  {
      "code": 0,
      "message": "退出成功！"
  }
  ```

* 退出时，将token置空

### 1.2.3 注册账户

* POST /signUp

* payload:

  ```json
  {
      "userId": "u1",
      "userName":"name",
      "userPassword":"abcdef",
      "userEmial": "xxxxx@xxxx.com"
      "userSex": "男",
      "userPhone": 13456737322,
      "userImage": "头像的路径",
      "userGrade": "年级",
      "userMajor": "专业",
      "userAcademy": "学院",
      "userIntroduction": "用户简介",
      "userType": 1
  }
  ```

* return : 

  ```json
  {
      "code": 0,
      "message": "注册成功！"
  }
  ```

* 这里的问题挺大的，从userPassword以下就可以全是空，以后要把type也变为默认值1

### 1.2.4 修改用户信息

* POST /updateUserInformation/{id}

* payload:

  ```json
  {
      "userName": "用户名",
      "userSex": "男",
      "userEmail": "xxxx@xxx.com",
      "userPhone": 125424235435,
      "userImage": "文件储存路径",
      "userGrade": "用户专业",
      "userAcademy": "用户学院",
      "userIntroduction": "用户介绍"
  }
  ```

  修改个人信息，注意这只保留一个不为空就可以传入了

* return:

  ```json
  {
      "code": 0,
      "message": "修改成功！"
  }
  ```



### 1.2.5 删除用户

* DELETE /deleteUserById/{id}

* payload: 

  request,表明用户类型

* return:

  ```json
  {
  	"code": 0,
      "message": "删除成功！"
  }
  ```



## 1.3 回答 Answer

* tips：

+ answerId = ans + 数字,以ans开头，数字为尾，这里要注意，我感觉不能要前端提供添加answer时生成id，这个后期我想办法解决
  + answerTop： 1为置顶，0为正常
  + answerContent: 用来存放answer文件的路径，这就要用到文件传输，这个我会之后解决 

### 1.3.1 根据用户的id（uid）获取该用户所有的回答

* GET  /getAnswersByUserId/{id}

* payload:

  request 里有userType

* return

  ```json
  {
       "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "ans1",
              "questionId": "q1",
              "answerContent": "存放answer文件的路径",
              "answerCreateTime": "2003-04-02 09:04:33.0",
              "answerTop": 1,
              "answerLikeNum": 123,
              "boardId": "b1",
              "userId": "u1"
          },
          {
           
          } 
     	]
  }
  ```

  这里有个问题，应该先读取文件保存地址后，取出文件传递到前端

### 1.3.2 根据问题的id（qid）获取其所有问题

* GET  /getAnswersByQuestion/{id}

* payload:

  request 里有用户类型userType

* return

  ```json
  {
       "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "ans1",
              "questionId": "q1",
              "answerContent": "存放answer文件的路径",
              "answerCreateTime": "2003-04-02 09:04:33.0",
              "answerTop": 1,
              "answerLikeNum": 123,
              "boardId": "b1",
              "userId": "u1"
          },
          ...
     	]
  }
  ```

  还是相同的问题



### 1.3.3 查找指定id（ansid）的回答

* GET /getAnswerById/{id}

* payload:

  request 里有userType

* return：

  ```json
  {
       "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "ans1",
              "questionId": "q1",
              "answerContent": "存放answer文件的路径",
              "answerCreateTime": "2003-04-02 09:04:33.0",
              "answerTop": 1,
              "answerLikeNum": 123,
              "boardId": "b1",
              "userId": "u1"
          },
          ...
     	]
  }
  ```

  get的所有方法都是这个问题



### 1.3.4 修改回答

* POST /updateAnswer/{id}

* payload:

  ```json
  {
      "answerContent": "文件储存路径",
      "answerLikeNum": 123,
      "answerTop": 1
  }
  ```

  这其中可以有一个不为空就行，而且answerContent也有文件传输问题

* return：

  ```json
  {
      "code": 0,
      "message": "修改成功！"
  }
  ```

  

### 1.3.5 删除回答

* POST  /deleteAnswerById/{id}

* payload : 

  request 中要有userType

* return : 

  ```json
  {
      "code": 0,
      "message": "删除成功！"
  }
  ```



### 1.3.6 添加回答

* POST /insertAnswer

* payload ：

  ```json
  {
      "answerId": "ans1",
      "userId": "u1",
      "answerContent":"文件储存路径"，
      "boardId": "b1",
      "questionId": "q1",
      "answerTop": 1,
      "answerCreateTime": "2020-2-23 20:23:33"
  }
  ```

* return : 

  ```json
  {
      "code": 0,
      "message": "添加成功！"
  }
  ```

  

### 1.3.7 为回答点赞

* POST /likeAnswer/{id}

* return :

  ```json
  {
      "code": 0,
      "message": "点赞成功！"
  }
  ```



## 1.4 文章 Article

* tops：
  + id： art + 数字 如：art1
  + 与answer同理articleContent也是文章文件储存路径，之后的文件传输也要修改
  + articleLock :文章锁 0为未上锁，1为上锁，无法修改评论，这个功能还不完善，待修改

### 1.4.1 删除指定id的文章

* DELETE  /delete/{id}

* payload :

  request 中有userType

* return :

  ```json
  {
      "code": 0,
      "message": "删除成功！"
  }
  ```

  

### 1.4.2 文章点赞

* POST  /like/{id}

* return ：

  ```json
  {
      "code": 0,
      "message": "点赞成功！"
  }
  ```



### 1.4.3 根据articleId查找文章

* GET  /getArticleById/{id}

* return : 

  ```json
  {
      "code": 0,
      "message": "success",
      "data": {
          "articleId": "art1",
          "articleLock": 0,
          "articleContent": "文章储存路径",
          "articleCreateTime": "2020-01-20 00:00:00.0",
          "userId": "u1",
          "articleLikeNum": 13
      }
  }
  ```



### 1.4.4 根据用户userId获取其所有文章

* GET /getArticlesByUserId/{id}

* return ：

  ```json
  {
      "code": 0,
      "message": "success",
      "data": [
          {
              "articleLock": 0,
              "articleCreateTime": "2020-01-20 00:00:00.0",
              "articleId": "art1",
              "articleContent": "文件储存路径",
              "userId": "u1",
              "articleLikeNum": 13
          },
          {
              ...
          }
              ...
      ]
  }
  ```

  

### 1.4.5 添加一篇文章

* POST  /insertArticle

* payload:

  ```json
  {
      "aricleId": "art1",
      "userId": "u1",
      "articleContent": "文件储存路径",
      "articleTitle": "文章标题",
      "articleCreateTime": "2020-3-2 08:08:32",
      "articleLock": 0
  }
  ```

* return:

  ```json
  {
      "code": 0,
      "message": "添加成功！"
  }
  ```



### 1.4.6 修改一篇文章

* POST  /updateArticleById/{id}

* payload:

  ```json
  {
      "articleContent": "文章储存路径",
      "articleLikeNum": 124,
      "articleTitle": "文章题目"
  }
  ```

* return : 

  ```json
  {
      "code": 0,
      "message": "修改成功！"
  }
  ```

  

## 1.5 板块 Board

* tips
  + boardId ： b + 数字 如：b1

### 1.5.1 添加一个板块

* POST  /insertBoard

* payload：

  ```json
  {
      "boardId": "b2",
      "boardName": "板块名称",
      "boardMasterId": "u1",
      "boardIntroduction": "板块介绍",
      "boardCreateTime": "2020-2-23 9:43:22"
  }
  ```

* return : 

  ```json
  {
      "code": 0,
      "message": "添加成功！"
  }
  ```



### 1.5.2 删除指定id的板块

* DELETE  /deleteBoardById/{id}

* payload : 

  request 带有userType

* return： 

  ```json
  {
      "code": 1,
      "message": "删除失败！"
  }
  ```



### 1.5.3 修改指定id的板块

* POST  /updateBoardById/{id}

* payload:

  ```json
  {
      "boardName": "板块名称",
      "boardMasterId": "u3",
      "boardIntroduction": "板块名称"
  }
  ```

* return:

  ```json
  {
      "code": 0,
      "message": "修改成功！"
  }
  ```



### 1.5.4 获取指定id的版块

* GET  /getBoardById/{id}

* payload : request带有userType

* return:

  ```json
  {
      "code": 0,
      "message": "success",
      "data": {
          "boardId": "b3",
          "boardCreateTime": "2009-09-09 22:33:44.0",
          "boardIntroduction": "板块介绍",
          "boardName": "板块名称",
          "boardMasterId": "u4"
      }
  }
  ```



### 1.5.5 获取指定id管理的所有板块

* GET  /getBoardByMasterId/{id}

* payload: request带有userType

* return：

  ```json
  {
      "code": 0,
      "message": "success",
      "data": {
          "boardId": "b3",
          "boardCreateTime": "2009-09-09 22:33:44.0",
          "boardIntroduction": "板块介绍",
          "boardName": "板块名称",
          "boardMasterId": "u4"
      }
  }
  ```

  

## 1.6 评论Comment

* tips：
  - commentId： c + 数字 如：c1
  - 评论的类型commentType有明显的区分：0为回答answer的评论，1为文章article的评论，2为评论comment的评论
  - 要注意：对评论的评论是toCommentId 也是c + 数字，就是其他评论的id
  - commentContent也是文件储存路径，也要解决

### 1.6.1 提交文章评论

* POST  /insertArticleComment/{articleId}

* payload :

  ```json
  {
      "commentId": "c1",
      "commentType": 1,
      "articleId": "art1",
      "commentContent": "评论文件路径",
      "commentCreateTime": "2020-4-2 9:43:2",
      "userId": "u1",
      "commentTop": 1
  }
  ```

* return：

  ```json
  {
      "code": 0,
      "message": "添加成功！"
  }
  ```



### 1.6.2 提交回答评论

* POST  /insertAnswerComment/{answerId}

* payload:

  ```json
  {
      "commentId": "c3",
      "commentType": 0,
      "answerId": "ans1",
      "commentContent": "评论文件路径",
      "commentCreateTime": "2020-4-2 9:43:2",
      "userId": "u1",
      "commentTop": 1
  }
  ```

* return :

  ```json
  {
      "code": 0,
      "message": "提交成功！"
  }
  ```



### 1.6.3 提交评论的评论

* POST  /insertCommentToComment/{toCommentId}

* payload:

  ```json
  {
      "commentId": "c2",
      "commentType": 0,
      "toCommentId": "c3",
      "commentContent": "评论文件路径",
      "commentCreateTime": "2020-4-2 9:43:2",
      "userId": "u1",
      "commentTop": 1
  }
  ```

* return :

  ```json
  {
      "code": 0,
      "message": "提交成功！"
  }
  ```



### 1.6.4 修改评论

* POST  /updateComment/{id}

* payload : 

  ```json
  {
      "commentContent": "文件储存路径",
      "commentLikeNum": 1,
      "commentTop": 1
  }
  ```

* return:

  ```json
  {
      "code": 1,
      "message": "修改失败！"
  }
  ```



### 1.6.5 删除评论

* POST  /deleteCommentById/{id}

* payload:

  request 带有userType

* return:

  ```json
  {
      "code": 0,
      "message": "删除成功！"
  }
  ```



### 1.6.6 获取指定id的回答answer的所有评论

* GET  /getCommentsByAnswerId/{id}

* return:

  ```json
  {
      "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "ans1",
              "toCommentId": "",
              "commentTop": 1,
              "commentType": 0,
              "articleId": "",
              "commentId": "c1",
              "commentContent": "com_content",
              "commentLikeNum": 123,
              "userId": "u1"
          },
          ...
      ]
  }
  ```



### 1.6.7 获取指定id文章article的所有评论

* GET  /getCommentsByArticleId/{id}

* return

  ```json
  {
      "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "",
              "toCommentId": "",
              "commentTop": 1,
              "commentType": 0,
              "articleId": "art1",
              "commentId": "c1",
              "commentContent": "com_content",
              "commentLikeNum": 123,
              "userId": "u1"
          },
          ...
      ]
  }
  ```

  

### 1.6.8 获取指定id评论comment的所有评论

* GET  /getCommentByCommentId/{id}

* return

  ```json
  {
      "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "",
              "toCommentId": "c3",
              "commentTop": 1,
              "commentType": 0,
              "articleId": "",
              "commentId": "c1",
              "commentContent": "com_content",
              "commentLikeNum": 123,
              "userId": "u1"
          },
          ...
      ]
  }
  ```



### 1.6.9 获取指定id评论

* GET  /getCommentById/{id}

* return

  ```json
  {
      "code": 0,
      "message": "success",
      "data": [
          {
              "answerId": "ans1",
              "toCommentId": "",
              "commentTop": 1,
              "commentType": 0,
              "articleId": "",
              "commentId": "c1",
              "commentContent": "com_content",
              "commentLikeNum": 123,
              "userId": "u1"
          },
          ...
      ]
  }
  ```

  

## 1.7 问题Question

* tips：
  - questionId: q + 数字 如：q1 ，所有id都是有问题的，因为没有办法要前端进行查找后再添加
  - questionContent问题依旧没有解决

### 1.7.1 添加一个问题

* POST  /insertQuestion

* payload:

  ```json
  {
      "questionId": "q1",
      "userId": "u1",
      "questionTitle": "问题的标题",
      "questionContent": "问题文件储存路径",
      "boardId": "b2",
      "questionCreateTime": "2020-3-3 08:08:29"
  }
  ```

  这些都是要传文件的

* return:

  ```json
  {
  	"code": 1,
      "message":"添加失败！"
  }
  ```



### 1.7.2 修改指定id的问题

* POST  /updateQuestion/{id}

* payload :

  ```json
  {
      "questionContent": "文件储存路径",
      "questionTitle": "文件标题"
  }
  ```

* return:

  ```json
  {
      "code": 0,
      "message": "修改成功！"
  }
  ```



### 1.7.3 删除指定id的问题

* DELETE /deleteQuestion/{id}

* request中要有userType

* return：

  ```json
  {
      "code": 1,
      "message": "删除失败！"
  }
  ```



### 1.7.4 获取指定id问题

* GET  /getQuestionById/{id}

* return 

  ```json
  {
      "code": 0,
      "message": "success",
      "data": {
          "questionContent": "qor4",
          "questionId": "hello",
          "questionTitle": null,
          "questionCreateTime": "2020-03-04 00:00:00.0",
          "boardId": "b2",
          "lock": 0,
          "userId": "u2"
      }
  } 
  ```



### 1.7.5 获取指定i用户的所有问题

* GET  /getQuestionByUserId/{id}

* return:

  ```json
  {
      "code": 0,
      "message": "success",
      "data": [
          {
              "questionContent": "qor4",
              "questionId": "hello",
              "questionTitle": null,
              "questionCreateTime": "2020-03-04 00:00:00.0",
              "boardId": "b2",
              "lock": 0,
              "userId": "u2"
          },
         ...
      ]
  }
  ```

  
