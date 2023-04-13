package Assignment3_final.client.view;

import Assignment3_final.client.view.chat.ChatViewController;
import Assignment3_final.client.view.logIn.LogInViewController;
import Assignment3_final.client.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory vmf;
    private Scene logInScene;
    private Scene chatScene;
    private Stage stage;

    public ViewHandler(ViewModelFactory vmf){
        this.vmf = vmf;
        stage = new Stage();
    }

    public void start(){
        openLogInView();

    }

    public void openLogInView(){
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/logIn/LogInView.fxml"));
        Parent root = loader.load();

        LogInViewController controller = loader.getController();
        controller.init(this, vmf.getLogInVM());


        logInScene = new Scene(root);
        stage.setScene(logInScene);
        stage.setTitle("Welcome to the Dark Side");
        stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openChatView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/chat/ChatView.fxml"));
            Parent root = loader.load();

            ChatViewController controller = loader.getController();
            controller.init(this, vmf.getChatVM());

            chatScene = new Scene(root);
            stage.setScene(chatScene);
            stage.setTitle("Dark Side");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
