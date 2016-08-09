define({ "api": [
  {
    "type": "post",
    "url": "/api/banner/list",
    "title": "01、获取banner列表",
    "version": "0.0.1",
    "name": "banner_list",
    "group": "banner",
    "description": "<p>获取banner列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "position",
            "description": "<p>位置 0:首页 1:商城</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>任务id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：1-益起来任务，2-脑洞开了没任务</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>任务名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>活动类型 0:个人 1:团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "startDate",
            "description": "<p>任务开始时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "endDate",
            "description": "<p>任务结束时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>活动地点</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "organizers",
            "description": "<p>主办方</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinNum",
            "description": "<p>已参加人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardYm",
            "description": "<p>奖励益米</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardIntegral",
            "description": "<p>奖励积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "detail",
            "description": "<p>详情</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/banner/api/BannerApi.java",
    "groupTitle": "banner",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/banner/list"
      }
    ]
  },
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
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          },
          {
            "group": "Parameter",
            "type": "file",
            "optional": false,
            "field": "vedio",
            "description": "<p>音频文件</p>"
          },
          {
            "group": "Parameter",
            "type": "files",
            "optional": false,
            "field": "images",
            "description": "<p>图片文件</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/collectList",
    "title": "06、显示收藏的朋友圈列表",
    "version": "0.0.1",
    "name": "dynamic_collectList",
    "group": "dynamic",
    "description": "<p>显示收藏的朋友圈列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
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
            "field": "list",
            "description": "<p>朋友圈列表集合</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>动态id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "vedioUrl",
            "description": "<p>音频路径</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "isTop",
            "description": "<p>是否置顶（1-是，0-否）</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "status",
            "description": "<p>状态（0-正常，1-删除）</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "user.nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.avater",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "images",
            "description": "<p>图片对象</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "images.imageUrl",
            "description": "<p>图片路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/collectList"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/comment/add",
    "title": "07、评论",
    "version": "0.0.1",
    "name": "dynamic_commentAdd",
    "group": "dynamic",
    "description": "<p>发表朋友圈</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "dynamic.id",
            "description": "<p>动态id</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "fromUser.id",
            "description": "<p>评论发起人id</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "toUser.id",
            "description": "<p>评论接收人id</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/comment/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/comment/delete",
    "title": "09、删除自己发起的评论",
    "version": "0.0.1",
    "name": "dynamic_commentDelete",
    "group": "dynamic",
    "description": "<p>删除自己发起的评论</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>当前登录用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "commentId",
            "description": "<p>动态id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/comment/delete"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/commentList",
    "title": "08、获取某条动态的评论列表",
    "version": "0.0.1",
    "name": "dynamic_commentList",
    "group": "dynamic",
    "description": "<p>获取某条动态的评论列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamicId",
            "description": "<p>动态id</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>评论id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>评论内容</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "createDate",
            "description": "<p>评论时间</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "fromUser",
            "description": "<p>发起评论用户对象</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "fromUser.id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "fromUser.nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "toUser",
            "description": "<p>被评论用户对象</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "toUser.id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "toUser.nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "images",
            "description": "<p>图片对象</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "images.imageUrl",
            "description": "<p>图片路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/commentList"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/delete",
    "title": "03、删除朋友圈",
    "version": "0.0.1",
    "name": "dynamic_delete",
    "group": "dynamic",
    "description": "<p>发表朋友圈</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>当前登录用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamicId",
            "description": "<p>动态id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/delete"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/give",
    "title": "10、打赏朋友圈",
    "version": "0.0.1",
    "name": "dynamic_give",
    "group": "dynamic",
    "description": "<p>打赏朋友圈</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamic.id",
            "description": "<p>动态id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "user.id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>打赏益米数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/give"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/list",
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
            "field": "list",
            "description": "<p>朋友圈列表集合</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>动态id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>标题</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "vedioUrl",
            "description": "<p>音频路径</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "isTop",
            "description": "<p>是否置顶（1-是，0-否）</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "status",
            "description": "<p>状态（0-正常，1-删除）</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isPraise",
            "description": "<p>是否点赞</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isCollect",
            "description": "<p>是否收藏</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "user.nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.avater",
            "description": "<p>用户头像</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "images",
            "description": "<p>图片对象</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "images.imageUrl",
            "description": "<p>图片路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/list"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/operate",
    "title": "04、点赞和取消点赞/收藏和取消收藏",
    "version": "0.0.1",
    "name": "dynamic_praise",
    "group": "dynamic",
    "description": "<p>发表朋友圈</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "oper",
            "description": "<p>操作：add-新增， cancel-取消</p>"
          },
          {
            "group": "Parameter",
            "type": "STRING",
            "optional": false,
            "field": "type",
            "description": "<p>操作类型：praise-点赞， collection-收藏</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamicId",
            "description": "<p>动态id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/operate"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/dynamic/praise/userList",
    "title": "05、获取某条动态的所有点赞用户",
    "version": "0.0.1",
    "name": "dynamic_praiseUserList",
    "group": "dynamic",
    "description": "<p>获取某条动态的所有点赞用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "dynamicId",
            "description": "<p>动态id</p>"
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
            "field": "list",
            "description": "<p>点赞用户集合</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "avater",
            "description": "<p>用户头像</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/dynamic/api/DynamicApi.java",
    "groupTitle": "dynamic",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/dynamic/praise/userList"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/product/exchange/codeList",
    "title": "06、查询兑换码",
    "version": "0.0.1",
    "name": "product_codeList",
    "group": "product",
    "description": "<p>查询兑换码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>手机/团体名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "productName",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "productType",
            "description": "<p>商品类型0:实物 1:众筹 2:广告位</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>所需益米</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>兑换码</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validStartDate",
            "description": "<p>开始有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validEndDate",
            "description": "<p>结束有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>兑换地址 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "isExchange",
            "description": "<p>是否已兑换（0-否，1-是）</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/product/api/ProductApi.java",
    "groupTitle": "product",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/product/exchange/codeList"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/product/detail",
    "title": "02、获取商品详情",
    "version": "0.0.1",
    "name": "product_detail",
    "group": "product",
    "description": "<p>获取商品详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "productId",
            "description": "<p>商品id</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>商品id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>商品类型 0:实物 1:众筹 2:广告位</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "detailImageUrl",
            "description": "<p>详情图片</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "shortDesc",
            "description": "<p>简短描述</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>所需益米（type=1时，表示单人所需益米）</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>type = 1时所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "buyNum",
            "description": "<p>type = 1时已经众筹人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validStartDate",
            "description": "<p>开始有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validEndDate",
            "description": "<p>结束有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>兑换地址 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "object",
            "optional": false,
            "field": "ads",
            "description": "<p>广告位规格</p>"
          },
          {
            "group": "Success 200",
            "type": "object",
            "optional": false,
            "field": "ads.days",
            "description": "<p>周期天数</p>"
          },
          {
            "group": "Success 200",
            "type": "object",
            "optional": false,
            "field": "ads.ym",
            "description": "<p>周期对应益米</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/product/api/ProductApi.java",
    "groupTitle": "product",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/product/detail"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/product/exchange",
    "title": "03、商品兑换",
    "version": "0.0.1",
    "name": "product_exchange",
    "group": "product",
    "description": "<p>商品兑换</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>兑换人类型：0-个人，1-团队</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "productId",
            "description": "<p>商品id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "days",
            "description": "<p>天数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/product/api/ProductApi.java",
    "groupTitle": "product",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/product/exchange"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/product/list",
    "title": "01、获取商品列表",
    "version": "0.0.1",
    "name": "product_list",
    "group": "product",
    "description": "<p>获取商品列表</p>",
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
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>商品id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>商品类型 0:实物 1:众筹 2:广告位</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "shortDesc",
            "description": "<p>简短描述</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>所需益米（type=1时，表示单人所需益米）</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>type = 1时所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "buyNum",
            "description": "<p>type = 1时已经众筹人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validStartDate",
            "description": "<p>开始有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validEndDate",
            "description": "<p>结束有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>兑换地址 type = 0</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/product/api/ProductApi.java",
    "groupTitle": "product",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/product/list"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/product/wish",
    "title": "04、获取许愿池详情",
    "version": "0.0.1",
    "name": "product_wish",
    "group": "product",
    "description": "<p>获取商品详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "productId",
            "description": "<p>商品id</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>商品id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>商品类型 0:实物 1:众筹 2:广告位</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "detailImageUrl",
            "description": "<p>详情图片</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "shortDesc",
            "description": "<p>简短描述</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>所需益米（type=1时，表示单人所需益米）</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>type = 1时所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "buyNum",
            "description": "<p>type = 1时已经众筹人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validStartDate",
            "description": "<p>开始有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validEndDate",
            "description": "<p>结束有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>兑换地址 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "object",
            "optional": false,
            "field": "ads",
            "description": "<p>广告位规格</p>"
          },
          {
            "group": "Success 200",
            "type": "object",
            "optional": false,
            "field": "ads.days",
            "description": "<p>周期天数</p>"
          },
          {
            "group": "Success 200",
            "type": "object",
            "optional": false,
            "field": "ads.ym",
            "description": "<p>周期对应益米</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/product/api/ProductApi.java",
    "groupTitle": "product",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/product/wish"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/product/wish/userList",
    "title": "05、获取许愿池的所有众筹用户",
    "version": "0.0.1",
    "name": "product_wishUsers",
    "group": "product",
    "description": "<p>获取许愿池的所有众筹用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "productId",
            "description": "<p>商品id</p>"
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
    "filename": "src/main/java/com/leoman/product/api/ProductApi.java",
    "groupTitle": "product",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/product/wish/userList"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/report/add",
    "title": "01、新增意见反馈",
    "version": "0.0.1",
    "name": "report_add",
    "group": "report",
    "description": "<p>新增意见反馈</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/report/api/ReportApi.java",
    "groupTitle": "report",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/report/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/task/detail",
    "title": "02、获取任务详情",
    "version": "0.0.1",
    "name": "task_detail",
    "group": "task",
    "description": "<p>获取任务详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：1-益起来任务，2-脑洞开了没任务</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>活动类型 0:个人 1:团队</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>任务id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：1-益起来任务，2-脑洞开了没任务</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>任务名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>活动类型 0:个人 1:团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "startDate",
            "description": "<p>任务开始时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "endDate",
            "description": "<p>任务结束时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>活动地点</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "organizers",
            "description": "<p>主办方</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinNum",
            "description": "<p>已参加人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardYm",
            "description": "<p>奖励益米</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardIntegral",
            "description": "<p>奖励积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "detail",
            "description": "<p>详情</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinStatus",
            "description": "<p>参加状态：null-未报名，0-进行中，1-已完成，2-未完成</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/task/api/TaskApi.java",
    "groupTitle": "task",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/task/detail"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/task/join",
    "title": "03、报名参加任务",
    "version": "0.0.1",
    "name": "task_join",
    "group": "task",
    "description": "<p>报名参加任务</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "taskId",
            "description": "<p>任务id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/task/api/TaskApi.java",
    "groupTitle": "task",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/task/join"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/task/list",
    "title": "01、获取任务列表",
    "version": "0.0.1",
    "name": "task_list",
    "group": "task",
    "description": "<p>获取任务列表</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：1-益起来任务，2-脑洞开了没任务</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>活动类型 0:个人 1:团队</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>任务id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：1-益起来任务，2-脑洞开了没任务</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>任务名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>活动类型 0:个人 1:团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "startDate",
            "description": "<p>任务开始时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "endDate",
            "description": "<p>任务结束时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>活动地点</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "organizers",
            "description": "<p>主办方</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinNum",
            "description": "<p>已参加人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardYm",
            "description": "<p>奖励益米</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardIntegral",
            "description": "<p>奖励积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "detail",
            "description": "<p>详情</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/task/api/TaskApi.java",
    "groupTitle": "task",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/task/list"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/task/upload",
    "title": "04、上传图片至已参加的任务进行审核",
    "version": "0.0.1",
    "name": "task_upload",
    "group": "task",
    "description": "<p>报名参加任务</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "taskId",
            "description": "<p>任务id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/task/api/TaskApi.java",
    "groupTitle": "task",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/task/upload"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/add",
    "title": "01、创建一个团队",
    "version": "0.0.1",
    "name": "team_add",
    "group": "team",
    "description": "<p>创建一个团队</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "file",
            "optional": false,
            "field": "cover",
            "description": "<p>团队封面</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/add"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/cover/upload",
    "title": "04、修改团队封面",
    "version": "0.0.1",
    "name": "team_coverUpload",
    "group": "team",
    "description": "<p>修改团队封面</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "teamId",
            "description": "<p>团队ID</p>"
          },
          {
            "group": "Parameter",
            "type": "FILE",
            "optional": false,
            "field": "file",
            "description": "<p>封面</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/cover/upload"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/edit",
    "title": "05、修改团队信息",
    "version": "0.0.1",
    "name": "team_edit",
    "group": "team",
    "description": "<p>修改团队封面</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "teamId",
            "description": "<p>团队ID</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "slogan",
            "description": "<p>口号</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/edit"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/info",
    "title": "03、获取一个团队的信息",
    "version": "0.0.1",
    "name": "team_info",
    "group": "team",
    "description": "<p>加入一个团队</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "teamId",
            "description": "<p>团队id</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "user.nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.avater",
            "description": "<p>用户头像</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/info"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/join",
    "title": "02、加入一个团队",
    "version": "0.0.1",
    "name": "team_join",
    "group": "team",
    "description": "<p>加入一个团队</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "teamId",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/join"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/list",
    "title": "07、排行榜-获取团队列表",
    "version": "0.0.1",
    "name": "team_list",
    "group": "team",
    "description": "<p>排行榜-获取团队列表</p>",
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
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "user.nickname",
            "description": "<p>用户昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "user.avater",
            "description": "<p>用户头像</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/list"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/team/quit",
    "title": "06、退出一个团队",
    "version": "0.0.1",
    "name": "team_quit",
    "group": "team",
    "description": "<p>退出一个团队</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "teamId",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/team/api/TeamApi.java",
    "groupTitle": "team",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/team/quit"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/task/list",
    "title": "11、分配团队活动的益米",
    "version": "0.0.1",
    "name": "user_allotYm",
    "group": "user",
    "description": "<p>分配团队活动的益米</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "taskJoinId",
            "description": "<p>活动参加id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>每人分配益米数</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/task/list"
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
            "description": "<p>index0:连续签到次数 index1:总共签到次数</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teams",
            "description": "<p>该用户创建的团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.id",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.coverUrl",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teamUsers",
            "description": "<p>用户团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.teamId",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.isHeader",
            "description": "<p>是否为群主（1-是，0-否）</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "userCas",
            "description": "<p>用户证书</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "userCas.caUrl",
            "description": "<p>证书路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/edit"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/exchange/record",
    "title": "14、查询个人/团队兑换记录",
    "version": "0.0.1",
    "name": "user_exchangeRecord",
    "group": "user",
    "description": "<p>查询个人/团队兑换记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>手机/团体名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "productName",
            "description": "<p>商品名称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "productType",
            "description": "<p>商品类型0:实物 1:众筹 2:广告位</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>所需益米</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>兑换码</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validStartDate",
            "description": "<p>开始有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "validEndDate",
            "description": "<p>结束有效期 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>兑换地址 type = 0</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "isExchange",
            "description": "<p>是否已兑换（0-否，1-是）</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/exchange/record"
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
        "url": "http://112.74.197.62:8080/zqc_app/api/user/head/upload"
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
            "description": "<p>index0:连续签到次数 index1:总共签到次数</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teams",
            "description": "<p>该用户创建的团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.id",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.coverUrl",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teamUsers",
            "description": "<p>用户团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.teamId",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.isHeader",
            "description": "<p>是否为群主（1-是，0-否）</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "userCas",
            "description": "<p>用户证书</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "userCas.caUrl",
            "description": "<p>证书路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/info"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/ym/record",
    "title": "12、查询用户/团队积分记录",
    "version": "0.0.1",
    "name": "user_integralRecord",
    "group": "user",
    "description": "<p>查询用户/团队积分记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>益米增减数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/ym/record"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/list",
    "title": "16、排行榜-个人列表",
    "version": "0.0.1",
    "name": "user_list",
    "group": "user",
    "description": "<p>排行榜-个人列表</p>",
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
            "description": "<p>index0:连续签到次数 index1:总共签到次数</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teams",
            "description": "<p>该用户创建的团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.id",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.coverUrl",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teamUsers",
            "description": "<p>用户团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.teamId",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.isHeader",
            "description": "<p>是否为群主（1-是，0-否）</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "userCas",
            "description": "<p>用户证书</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "userCas.caUrl",
            "description": "<p>证书路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/list"
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
            "description": "<p>index0:连续签到次数 index1:总共签到次数</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teams",
            "description": "<p>该用户创建的团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.id",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.name",
            "description": "<p>团队名称</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.slogan",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.coverUrl",
            "description": "<p>团队口号</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.integral",
            "description": "<p>积分</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teams.ym",
            "description": "<p>益米</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "teamUsers",
            "description": "<p>用户团队信息</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.teamId",
            "description": "<p>团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "teamUsers.isHeader",
            "description": "<p>是否为群主（1-是，0-否）</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "userCas",
            "description": "<p>用户证书</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "userCas.caUrl",
            "description": "<p>证书路径</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/login"
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
        "url": "http://112.74.197.62:8080/zqc_app/api/user/password/edit"
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
        "url": "http://112.74.197.62:8080/zqc_app/api/user/password/code/valid"
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
        "url": "http://112.74.197.62:8080/zqc_app/api/user/password/reset"
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
        "url": "http://112.74.197.62:8080/zqc_app/api/userInfo/register"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/sign",
    "title": "15、签到",
    "version": "0.0.1",
    "name": "user_sign",
    "group": "user",
    "description": "<p>签到</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/sign"
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
        "url": "http://112.74.197.62:8080/zqc_app/api/user/sms/code"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/task/list",
    "title": "10、获取活动记录",
    "version": "0.0.1",
    "name": "user_taskList",
    "group": "user",
    "description": "<p>获取活动记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "status",
            "description": "<p>状态：0-进行中，1-已完成，2-未完成：</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "id",
            "description": "<p>参加id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "status",
            "description": "<p>状态：0-进行中，1-已完成，2-未完成</p>"
          },
          {
            "group": "Success 200",
            "type": "Object",
            "optional": false,
            "field": "task",
            "description": "<p>任务对象</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：1-益起来任务，2-脑洞开了没任务</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>任务名称</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "coverUrl",
            "description": "<p>封面图片</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinType",
            "description": "<p>活动类型 0:个人 1:团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "startDate",
            "description": "<p>任务开始时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "endDate",
            "description": "<p>任务结束时间</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>活动地点</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "organizers",
            "description": "<p>主办方</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "nums",
            "description": "<p>所需人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinNum",
            "description": "<p>已参加人数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardYm",
            "description": "<p>奖励益米</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "rewardIntegral",
            "description": "<p>奖励积分</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "detail",
            "description": "<p>详情</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/task/list"
      }
    ]
  },
  {
    "type": "post",
    "url": "/api/user/ym/record",
    "title": "13、查询用户/团队益米记录",
    "version": "0.0.1",
    "name": "user_ymRecord",
    "group": "user",
    "description": "<p>查询用户/团队益米记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Parameter",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
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
            "type": "NUMBER",
            "optional": false,
            "field": "type",
            "description": "<p>类型：0-个人，1-团队</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "joinId",
            "description": "<p>用户id或团队id</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "ym",
            "description": "<p>益米增减数</p>"
          },
          {
            "group": "Success 200",
            "type": "NUMBER",
            "optional": false,
            "field": "content",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/leoman/user/api/UserInfoApi.java",
    "groupTitle": "user",
    "sampleRequest": [
      {
        "url": "http://112.74.197.62:8080/zqc_app/api/user/ym/record"
      }
    ]
  }
] });
