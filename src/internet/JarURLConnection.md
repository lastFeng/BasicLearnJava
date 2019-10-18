### JarURLConnection

- Java的JarURLConnection类用来连接Java jar文件，一旦连接上，你可以获取jar文件信息

#### Simple example
```java
    String urlString =  "http://butterfly.jenkov.com/"
                                        + "container/download/"
                                        + "jenkov-butterfly-container-2.9.9-beta.jar";
    URL jarUrl = new URL(urlString);
    JarURLConnection connection = new JarURLConnection(jarUrl);

    Manifest mainfest = connection.getManifest();
    JarFile jarFile = connection.getJarFile();
    // other operations...
```