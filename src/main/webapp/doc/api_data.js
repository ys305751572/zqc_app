define({ "api": [
  {
    "type": "post",
    "url": "/api/dynamic/add",
    "title": "01、发表朋友圈",
    "version": "0.0.1",
    "name": "dynamic_add",
    "group": "dynamic",
    "description": "<p>发表朋友圈</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "gender",
            "description": "<p>性别 男:0 女:1</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "code",
            "description": "<p>验证码</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/dynamic/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/login",
    "title": "02、获取朋友圈列表",
    "version": "0.0.1",
    "name": "dynamic_list",
    "group": "dynamic",
    "description": "<p>获取朋友圈列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "pageNum",
            "description": "<p>页码</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "pageSize",
            "description": "<p>每页请求数</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "dynamic",
            "description": "<p>用户对象</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamic.id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamic.gender",
            "description": "<p>性别 男-0，女-1</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.avater",
            "description": "<p>头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.status",
            "description": "<p>状态 0:正常 1:冻结</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.level",
            "description": "<p>会员等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.IDCard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "dynamic.sign",
            "description": "<p>index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/dynamic/login"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/edit",
    "title": "04、修改个人信息",
    "version": "0.0.1",
    "name": "user_edit",
    "group": "user",
    "description": "<p>修改用户个人信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": true,
            "field": "nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": true,
            "field": "sex",
            "description": "<p>性别(0男,1女)</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "user",
            "description": "<p>用户对象</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "user.id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.gender",
            "description": "<p>性别</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.avater",
            "description": "<p>头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.status",
            "description": "<p>状态 0:正常 1:冻结</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.level",
            "description": "<p>会员等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.IDCard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.sign",
            "description": "<p>index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/edit"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/head/upload",
    "title": "05、上传用户头像",
    "version": "0.0.1",
    "name": "user_head_upload",
    "group": "user",
    "description": "<p>上传用户头像</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "FILE",
            "optional": false,
            "field": "file",
            "description": "<p>头像</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/head/upload"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/info",
    "title": "03、获取用户信息",
    "version": "0.0.1",
    "name": "user_info",
    "group": "user",
    "description": "<p>获取用户信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/info"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/login",
    "title": "01、登录",
    "version": "0.0.1",
    "name": "user_login",
    "group": "user",
    "description": "<p>用户登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "username",
            "description": "<p>用户名</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "user",
            "description": "<p>用户对象</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "user.id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "user.gender",
            "description": "<p>性别 男-0，女-1</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.avater",
            "description": "<p>头像</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.status",
            "description": "<p>状态 0:正常 1:冻结</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.level",
            "description": "<p>会员等级</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.IDCard",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.sign",
            "description": "<p>index0 : 今日是否签到 0:未签到 1:已签到 index1:连续签到次数 index2:总共签到次数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/login"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/password/edit",
    "title": "06、修改密码-通过原密码修改密码",
    "version": "0.0.1",
    "name": "user_password_edit",
    "group": "user",
    "description": "<p>使用旧密码修改密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "oldPassword",
            "description": "<p>旧密码(MD5)</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "newPassword",
            "description": "<p>新密码(MD5)</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/password/edit"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/password/code/valid",
    "title": "08、找回密码-校验验证码是否正确",
    "version": "0.0.1",
    "name": "user_password_find_edit",
    "group": "user",
    "description": "<p>使用验证码修改密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>验证码</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/password/code/valid"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/password/reset",
    "title": "09、修改密码-找回密码验证码验证成功后，重设密码",
    "version": "0.0.1",
    "name": "user_password_reset",
    "group": "user",
    "description": "<p>使用旧密码修改密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "newPassword",
            "description": "<p>新密码(MD5)</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/password/reset"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/userInfo/register",
    "title": "02、注册",
    "version": "0.0.1",
    "name": "user_register",
    "group": "user",
    "description": "<p>用户注册</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "gender",
            "description": "<p>性别 男:0 女:1</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "code",
            "description": "<p>验证码</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/userInfo/register"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/sms/code",
    "title": "07、发送验证码",
    "version": "0.0.1",
    "name": "user_sms_code",
    "group": "user",
    "description": "<p>根据类型发送验证码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": true,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "type",
            "description": "<p>验证码类型(PASSWORD 找回密码验证码，REGISTER 注册验证码)</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://localhost:8081/zqc_app/api/user/sms/code"
      }
    ]
  }
] });
