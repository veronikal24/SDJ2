package Assignment3_final.client;

import Assignment3_final.client.model.ModelFactory;
import Assignment3_final.client.view.ViewHandler;
import Assignment3_final.client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientApp extends Application {
    public void start(Stage stage) throws Exception{

        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(vmf);
        viewHandler.start();

    }
}
