

import java.io.IOException;

import implicit.AlphabeticShifter;
import implicit.CircularShifter;
import implicit.IgnoredWordsShifter;
import implicit.ObservableLines;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

	private final ObservableLines lines, result , ignoredWords;
	
	public static void main(String[] args) throws IOException {
		Application.launch(args);
	}

	public GUI() {
		result = new ObservableLines(new AlphabeticShifter());

		ignoredWords = new ObservableLines(new IgnoredWordsShifter(result));
		lines = new ObservableLines(new CircularShifter(ignoredWords , result));
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * INPUT LINES
		 */
		TextArea linesIn = new TextArea();
		linesIn.setPrefSize(300, 400);
		Button addLines = new Button("Add lines");
		addLines.setOnAction(e->{
			String[] toAdd = readInput(linesIn.getText());
			lines.get().addAll(toAdd);
			linesIn.setText("");
		});
		addLines.setAlignment(Pos.BOTTOM_RIGHT);
		BorderPane buttonPane = new BorderPane();
		buttonPane.setBottom(addLines);
		BorderPane linesInput = new BorderPane(linesIn,null,buttonPane,null,null);
		
		/*
		 * REMOVE LINES
		 */
		ChoiceBox<String> selectLine = new ChoiceBox<>(lines.get());
		Button rmLine = new Button("Remove line");
		rmLine.setOnAction(e->{
			String value = selectLine.getValue();
			if( value != null){
				lines.get().remove(value);
			}
		});
		
		BorderPane linesRemoval = new BorderPane(selectLine,null,rmLine,null,null);
		
		/*
		 * INPUT IGNORED WORDS
		 */
		TextArea ignoredIn = new TextArea();
		ignoredIn.setPrefSize(200, 400);
		Button addIgnored = new Button("Add ignored words");
		addIgnored.setOnAction(e->{
			String[] toAdd = readInput(ignoredIn.getText());
			ignoredWords.get().addAll(toAdd);
			ignoredIn.setText("");
		});
		addIgnored.setAlignment(Pos.BOTTOM_RIGHT);
		BorderPane button2Pane = new BorderPane();
		button2Pane.setBottom(addIgnored);
		BorderPane ignoredInput = new BorderPane(ignoredIn,null,button2Pane,null,null);
		
		
		/*
		 * INPUT ROOT
		 */
		BorderPane inputPane = new BorderPane(linesInput, null, ignoredInput, linesRemoval, null);
		
		/*
		 * LIST VIEW
		 */
		ListView<String> linesView = new ListView<>(lines.get());
		ListView<String> ignoredView = new ListView<>(ignoredWords.get());
		ListView<String> resultView = new ListView<>(result.get());
		linesView.setPrefSize(400, 300);
		ignoredView.setPrefSize(400, 300);
		resultView.setPrefSize(400, 600);
		
		Text resText = new Text("Result:");
		BorderPane resultViewPane = new BorderPane(resultView,resText,null,null,null);
		
		Text linesText = new Text("Lines:");
		BorderPane linesViewPane = new BorderPane(linesView,linesText,null,null,null);

		Text ignoredText = new Text("Ignored words:");
		BorderPane ignoredViewPane = new BorderPane(ignoredView,ignoredText,null,null,null);
		
		BorderPane leftPane = new BorderPane(null, linesViewPane, null,ignoredViewPane , null) ;
		BorderPane resultPane = new BorderPane(null, null, resultViewPane, null, leftPane);
		
		/*
		 * ROOT
		 */
		TabPane root = new TabPane();
		root.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		root.getTabs().add(new Tab("Input", inputPane));
		root.getTabs().add(new Tab("Results", resultPane));
		
		/*
		 * WINDOW
		 */
		Scene scene = new Scene(root);

        primaryStage.setTitle("Assignment1: Implicit version");
        primaryStage.setScene(scene);
        primaryStage.show();

	}

	private static String[] readInput(String inputLines) {
		return inputLines.split("\n");
	}

}
