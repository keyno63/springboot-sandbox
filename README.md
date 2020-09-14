# spring_tutorial

Spring Boot のお試し.  
いろいろなライブラリも試している.  

## 環境
使っている環境.  
バージョンなども記載しているが、実装時の新しいもの使用.
- Java: Java Version 14.0.1(14.0.1.hs-adpt)
- gradle: 6.6
- Spring Boot: 2.3

## 起動  
CLI からの実行は gradle wrapper から実行.  
```bash
./gradlew bootRun
```

IDE(Intellij など)の場合は実行タスクから起動してください.  

## 実装選択の意図  

後から見返す用

### Java Properties について

`@ConfigurationPropertiesScan` を使う.  
`@SpringApplication` をつける class につけ、設定 class を読み込むようにする.  
