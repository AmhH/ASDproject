
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import edu.mum.framework.ui.InitLoader;
import edu.mum.framework.ui.Loader;
import edu.mum.framework.ui.Navigator;

public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/edu/mum/framework/ui/Login.fxml"));
			Scene scene = new Scene(root, 800, 600);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);
			
			primaryStage.show();
			Navigator.getInstance().setPrimaryStage(primaryStage);
			
			Loader loader = Loader.getInstance();
			loadInitialConfig();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	private void loadInitialConfig(){
		/**
		 * Here you must include files that need config from the 
		 * UIConfig.xml to be loaded
		 * 
		 * All of them must implement InitLoader class
		 */
		List<InitLoader> loaders = new ArrayList<>();
		loaders.add(Navigator.getInstance());
		for(InitLoader loader: loaders) loader.loadInitialData();
	}
	
}
