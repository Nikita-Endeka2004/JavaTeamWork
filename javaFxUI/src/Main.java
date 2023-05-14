import App.BackEnd;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GrapherUI_Fx grapherUIFx = new GrapherUI_Fx();
        BackEnd backEnd = new BackEnd();
        javaFx grapher = new javaFx(grapherUIFx, backEnd);
        grapher.run();
        grapherUIFx.start(stage);
    }
}