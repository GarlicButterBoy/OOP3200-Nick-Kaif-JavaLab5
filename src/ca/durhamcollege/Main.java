//Nick Sturch-Flint & Kaifkhan Vakil
//December 18, 2020
//Program: Java Lab 5
//

package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main extends Application
{

    public static double round(double value, int places)
    {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Java Lab 5");

        // Step 1 - create one or more control
        //Step 1 for images is to load the images
        Label heightLabel = new Label("My Height (In metres): ");
        Label weightLabel = new Label("My Weight (In Kilograms): ");
        Label result = new Label("Category of BMI");
        TextField inputHeight = new TextField();
        TextField inputWeight = new TextField();
        Label output = new Label("For showing calculated BMI");
        Button findBMI = new Button("Calculate BMI");

        // Step 1.1 - Configure your controls
        //output.disabledProperty();

        // Step 1.2 - For button controls (or other event-type controls) - set the event
        findBMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double weight = Double.parseDouble(inputWeight.getText());
                double height = Double.parseDouble(inputHeight.getText());
                final double answer = weight / (height * height);
                String s = round(answer, 2)+"";
                output.setText(s);

                if (answer < 18.5)
                {
                    result.setText("Underweight");
                }
                else if (answer >= 18.5 && answer < 25)
                {
                    result.setText("Normal");
                }
                else if (answer >= 25 && answer < 30)
                {
                    result.setText("Overweight");
                }
                else
                {
                    result.setText("Obese");
                }
            }
        });
/*
        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        }
*/
        // Step 2 - create a container
        //Step 2 for images is setup the image view
        GridPane gridPane = new GridPane();
        HBox hBox = new HBox(10, heightLabel, inputHeight);
        HBox hBox1 = new HBox(10, weightLabel, inputWeight);


        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, 800, 300);
        gridPane.setMinSize(6, 8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hBox, 0, 0);
        gridPane.add(hBox1, 0, 1);
        gridPane.add(findBMI, 0, 2);
        gridPane.add(output,2, 2);
        gridPane.add(result, 2, 6);
        result.setStyle("-fx-alignment: center");
        gridPane.setStyle("-fx-font-size: 20; -fx-border-color: Black");


        // Step 4 - add scene to stage
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
