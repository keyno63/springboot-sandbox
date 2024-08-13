# springboot-sandbox

## OverView

Spring Boot の実装を色々と試すためのレポジトリです.  
Java のいろいろなライブラリの動作, 実装も試しています.  

## 環境
使っている環境.  
バージョンなども記載しているが、実装時の新しいもの使用.
- Java: Java Version 16
- gradle: 7.0
- Spring Boot: 2.5

## Usage

CLI からの実行方法について記載します.  
CLI からの実行は gradle wrapper から実行.  
IDE(Intellij など)の場合は実行タスクから起動してください.

### 起動  

```bash
./gradlew bootRun
```

### build

SpringBoot 実行用の jar ファイルを生成します

```bash
./gradlew build
```

`./build/libs/` 配下に jar ファイルが生成されます

### Test

JUnit5 を用いた単体テストを実行します

```bash
./gradlew test
```

## format

spotless を使ったオートフォーマット  
gradle plugin の spotless を適用しているので、コマンドから自動でする
```bash
./gradlew spotlessApply
```

## 実装選択の意図  

後から見返す用

### Java Properties について

`@ConfigurationPropertiesScan` を使う.  
`@SpringApplication` をつける class につけ、設定 class を読み込むようにする.  

## License

This repository is Apache2 License.  
see [License](./LICENSE) file.
