package com.github.sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;

public class Demo extends Application {

    public void start(Stage stage){
        // stageの基本設定
        stage.setTitle("タイトル");
        stage.setWidth(800);
        stage.setHeight(500);
        // Controlの設定
        Button button1 = new Button("ボタン１");
        Button button2 = new Button("ボタン２");
        // Paneの設定
        FlowPane root = new FlowPane();
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        // 仕上げ
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(); // アプリケーション起動
    }
}
