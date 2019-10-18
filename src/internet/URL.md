### URL + URLConnection

#### 简单示例
```java
    URL url = new URL("http://jenkov.com");
    URLConnection urlConnection = url.openConnection();
    InputStream input = urlConnection.getInputStream();
    int data = input.read();
    while(data != -1){
        System.out.print((char) data);
        data = input.read();
    }
    input.close();
```

#### HTTP GET和POST
- 默认情况下URLConnection发送一个HTTP GET请求到web服务器
- HTTP POST，需要调用URLConnection.setDoOutput(true)
```java
    URL url = new URL("address");
    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);

    OutputStream out = connection.getOutputStream();

    // 向out流中写入需要POST的数据，但需要将其转换成URL编码
    // TODO:
    out.close();
```

#### 从URLs到本地文件
- URL也被叫做统一资源定位符，利用URL打开本地文件系统

```java
    URL url = new URL("file:/c:/data/test.txt");
    URLConnection connection = url.openConnection();
    InputStream input = connection.getInputStream();

    int data = input.read();
    while(data != -1) {
        System.out.print((char)data);
        data = input.read();
    }
    input.close();
```