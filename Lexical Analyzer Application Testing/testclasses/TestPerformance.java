package br.ufop.tomaz;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import br.ufop.tomaz.model.Lexeme;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class TestPerformance extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException {
        URL url = Main.class.getResource("fxml/FXMLMain.fxml");
        Parent mainNode = FXMLLoader.load(url);
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    
    @Test
    public void testPerformance1() throws InterruptedException {
        clickOn("#codeTextArea");
        long then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("i := 1 \n");
        }
        clickOn("#btnAnalyze");
        long now = System.currentTimeMillis(); 
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens for one line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);        
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("i := 1 \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens for one line: " + (now - then) + "," + tableView.getItems().size());
        clickOn("#clearCodeArea");
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("i := 1 \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens for one line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);
        clickOn("#clearCodeArea");
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("i := 1 \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens for one line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);

    }

    @Test
    public void testPerformance2() throws InterruptedException {
        clickOn("#codeTextArea");
        long then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("if ( 2 * 3 = 6 ) \n    print ( \"six\" ) \n");
        }
        clickOn("#btnAnalyze");
        long now = System.currentTimeMillis(); 
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens two line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);
        clickOn("#clearCodeArea");
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("if ( 2 * 3 = 6 ) \n    print ( \"six\" ) \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens two line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);
        clickOn("#clearCodeArea");
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("if ( 2 * 3 = 6 ) \n    print ( \"six\" ) \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens two line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);

    }

    @Test
    public void testPerformance3() throws InterruptedException {
        clickOn("#codeTextArea");
        long then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("while ( true ) {\n    i + + ;\n    print ( 3 * 4 ) ; } \n");
        }
        clickOn("#btnAnalyze");
        long now = System.currentTimeMillis(); 
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens three line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);
        clickOn("#clearCodeArea");
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("if ( 2 * 3 = 6 ) \n    print ( \"six\" ) \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens three line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);
        clickOn("#clearCodeArea");
        clickOn("#codeTextArea");
        then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            write("if ( 2 * 3 = 6 ) \n    print ( \"six\" ) \n");
        }
        clickOn("#btnAnalyze");
        now = System.currentTimeMillis(); 
        tableView = lookup("#tokensTable").query();
        System.out.println("Elapsed time and number of tokens three line: " + (now - then) + "," + tableView.getItems().size());
        Thread.sleep(10000);

    }
    
}
