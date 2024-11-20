package com.example.javafxsum;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField number1Field = new TextField();
        number1Field.setPromptText("Введите первое число");

        TextField number2Field = new TextField();
        number2Field.setPromptText("Введите второе число");
        Button calculateButton = new Button("Посчитать сумму");

        Label resultLabel = new Label();

        calculateButton.setOnAction(event -> {
            try {
                double number1 = Double.parseDouble(number1Field.getText());
                double number2 = Double.parseDouble(number2Field.getText());
                double sum = number1 + number2;

                resultLabel.setText("Сумма: " + sum);
            } catch (NumberFormatException e) {
                resultLabel.setText("Пожалуйста, введите корректные числа.");
            }
        });

        VBox root = new VBox(10, number1Field, number2Field, calculateButton, resultLabel);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Калькулятор суммы");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}