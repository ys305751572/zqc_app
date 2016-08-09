define({
  "name": "致青春接口文档",
  "version": "0.0.1",
  "description": "",
  "title": "Custom apiDoc browser title",
  "url": "http://112.74.197.62:8080/zqc_app",
  "sampleUrl": "http://112.74.197.62:8080/zqc_app",
  "header": {
    "title": "start",
    "content": "<h3>接口返回格式</h3>\n<h2>单条数据:</h2>\n<blockquote>\n<p>异常:</p>\n</blockquote>\n<pre><code class=\"language-javascript\">{ \n &quot;status&quot;:1000,\n &quot;data&quot;:{},\n &quot;msg&quot;:&quot;错误消息&quot;\n}\n</code></pre>\n<blockquote>\n<p>正常:</p>\n</blockquote>\n<pre><code class=\"language-javascript\">{\n &quot;status&quot;:0,\n &quot;data&quot;:{&quot;id&quot;:&quot;1&quot;,&quot;name&quot;:&quot;wb&quot;},\n &quot;msg&quot;:&quot;&quot;\n}\n</code></pre>\n<h2>多条数据:</h2>\n<blockquote>\n<p>异常:</p>\n</blockquote>\n<pre><code class=\"language-javascript\">{\n &quot;status&quot;:1000,\n &quot;data&quot;:{},\n &quot;msg&quot;:&quot;错误消息&quot;\n}\n</code></pre>\n<blockquote>\n<p>正常:</p>\n</blockquote>\n<pre><code class=\"language-javascript\">{\n &quot;status&quot;:0,\n &quot;data&quot;:{\n   &quot;list&quot;:[\n     {&quot;id&quot;:267,&quot;city&quot;:&quot;Wuhan&quot;},\n     {&quot;id&quot;:266,&quot;city&quot;:&quot;Nanjin&quot;}\n   ],\n   &quot;page&quot;:{\n     &quot;totalNum&quot;:4,\n     &quot;totalPage&quot;:2,\n     &quot;currentPage&quot;:1\n   }\n }  \n}\n</code></pre>\n<h3>错误码</h3>\n<table>\n<thead>\n<tr>\n<th>解释</th>\n<th>错误码</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>参数不正确</td>\n<td>1001</td>\n</tr>\n<tr>\n<td>服务器异常</td>\n<td>1002</td>\n</tr>\n<tr>\n<td>url不存在</td>\n<td>1003</td>\n</tr>\n<tr>\n<td>手机号已被注册</td>\n<td>2001</td>\n</tr>\n<tr>\n<td>验证码错误</td>\n<td>2002</td>\n</tr>\n<tr>\n<td>用户名密码错误</td>\n<td>2003</td>\n</tr>\n<tr>\n<td>用户不存在</td>\n<td>2004</td>\n</tr>\n</tbody>\n</table>\n"
  },
  "template": {
    "forceLanguage": "zh",
    "withCompare": true,
    "withGenerator": true
  },
  "apidoc": "0.2.0",
  "generator": {
    "name": "apidoc",
    "time": "2016-08-09T03:13:23.881Z",
    "url": "http://apidocjs.com",
    "version": "0.16.1"
  }
});
