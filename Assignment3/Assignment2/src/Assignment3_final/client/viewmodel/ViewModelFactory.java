package Assignment3_final.client.viewmodel;

import Assignment3_final.client.model.ModelFactory;

public class ViewModelFactory {
    private ModelFactory mf;
    public ViewModelFactory(ModelFactory mf){

        this.mf = mf;
    }
    public LogInViewModel getLogInVM(){

        return new LogInViewModel(mf.getClientModel());
    }
    public ChatViewModel getChatVM() {

        return new ChatViewModel(mf.getClientModel());
    }
}
