//package interface_adapter.modify_events;
//
//import interface_adapter.ViewManagerModel;
//import interface_adapter.login.LoginViewModel;
//import use_case.modify_events.ModifyOutputBoundary;
//import use_case.modify_events.ModifyOutputData;
//
//public class ModifyPresenter implements ModifyOutputBoundary {
//
//    //TODO: These view models might have to be changed later
//
//    private final ModifyViewModel modifyViewModel;
//    private final LoginViewModel loginViewModel;
//    private final ViewManagerModel viewManagerModel;
//
//    public ModifyPresenter(ModifyViewModel modifyViewModel, LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
//        this.modifyViewModel = modifyViewModel;
//        this.loginViewModel = loginViewModel;
//        this.viewManagerModel = viewManagerModel;
//    }
//
//    @Override
//    public void prepareSuccessView(ModifyOutputData event) {
//        //TODO: Finish this once viewmodels are implemented
//        State loginState = loginViewModel.getState();
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//        //TODO: Finish this once viewmodels are implemented
//        ModifyState modifyState = modifyViewModel.getState();
//        modifyState.setEventError(error);
//        modifyViewModel.firePropertyChanged();
//    }
//}
