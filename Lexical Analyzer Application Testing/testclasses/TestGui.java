package br.ufop.tomaz;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.control.TableViewMatchers;

import br.ufop.tomaz.model.Lexeme;
import br.ufop.tomaz.model.Token;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static org.junit.Assert.*;
//import static org.testfx.api.FxAssert.verifyThat;

public class TestGui extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException {
        URL url = Main.class.getResource("fxml/FXMLMain.fxml");
        Parent mainNode = FXMLLoader.load(url);
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void testAnalyzer1() throws InterruptedException {
        clickOn("#codeTextArea");
        write("i := 1");
        clickOn("#btnAnalyze");
        Thread.sleep(10000);
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        assertEquals(Token.INTEGER, tableView.getItems().get(0).getToken());
        assertEquals(Token.ASSIGNMENT_OPERATOR, tableView.getItems().get(1).getToken());
        assertEquals(Token.IDENTIFIER, tableView.getItems().get(2).getToken());

    }

    @Test
    public void testAnalyzer2() throws InterruptedException {
        clickOn("#codeTextArea");
        write("if ( 2 * 3 = 6 ) \n    print ( \"six\" )");
        clickOn("#btnAnalyze");
        Thread.sleep(10000);
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        assertEquals(Token.INTEGER, tableView.getItems().get(0).getToken());
        assertEquals(Token.INTEGER, tableView.getItems().get(1).getToken());
        assertEquals(Token.INTEGER, tableView.getItems().get(2).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(3).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(4).getToken());
        assertEquals(Token.TIMES, tableView.getItems().get(5).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(6).getToken());
        assertEquals(Token.EQUAL, tableView.getItems().get(7).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(8).getToken());
        assertEquals(Token.STRING, tableView.getItems().get(9).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(10).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(11).getToken());

    }

    @Test
    public void testAnalyzer3() throws InterruptedException {
        clickOn("#codeTextArea");
        write("while ( true ) {\n    i + + ;\n    print ( 3 * 4 ) ; }");
        clickOn("#btnAnalyze");
        Thread.sleep(10000);
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(0).getToken());
        assertEquals(Token.IDENTIFIER, tableView.getItems().get(1).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(2).getToken());
        assertEquals(Token.LEFT_BRACE, tableView.getItems().get(3).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(4).getToken());
        assertEquals(Token.IDENTIFIER, tableView.getItems().get(5).getToken());
        assertEquals(Token.PLUS, tableView.getItems().get(6).getToken());
        assertEquals(Token.SEMICOLON, tableView.getItems().get(7).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(8).getToken());
        assertEquals(Token.INTEGER, tableView.getItems().get(9).getToken());
        assertEquals(Token.INTEGER, tableView.getItems().get(10).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(11).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(12).getToken());
        assertEquals(Token.TIMES, tableView.getItems().get(13).getToken());
        assertEquals(Token.SEMICOLON, tableView.getItems().get(14).getToken());
        assertEquals(Token.RIGHT_BRACE, tableView.getItems().get(15).getToken());

    }

    @Test
    public void testAnalyzer4() {
        clickOn("#codeTextArea");
        write("i:= 89nns");
        clickOn("#btnAnalyze");
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        assertEquals(Token.IDENTIFIER, tableView.getItems().get(0).getToken());
        assertEquals(Token.ASSIGNMENT_OPERATOR, tableView.getItems().get(1).getToken());
        assertEquals(Token.IDENTIFIER, tableView.getItems().get(2).getToken());

    }

    @Test
    public void testAnalyzer5() {
        clickOn("#codeTextArea");
        write("if ( 3-1.0=2 ) \n");
        write("    print( \"one\" )");
        clickOn("#btnAnalyze");
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        assertEquals(Token.INTEGER, tableView.getItems().get(0).getToken());
        assertEquals(Token.INTEGER, tableView.getItems().get(1).getToken());
        assertEquals(Token.FLOAT, tableView.getItems().get(2).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(3).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(4).getToken());
        assertEquals(Token.TIMES, tableView.getItems().get(5).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(6).getToken());
        assertEquals(Token.EQUAL, tableView.getItems().get(7).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(8).getToken());
        assertEquals(Token.STRING, tableView.getItems().get(9).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(10).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(11).getToken());

    }

    @Test
    public void testAnalyzer6() {
        clickOn("#codeTextArea");
        write("while(false) {\n    4++;\n    print (null); }");
        clickOn("#btnAnalyze");
        TableView<Lexeme> tableView = lookup("#tokensTable").query();
        tableView.getItems().forEach(lexeme -> {
            System.out.println(lexeme.getValue() + ":" + lexeme.getToken().name());
        });
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(0).getToken());
        assertEquals(Token.IDENTIFIER, tableView.getItems().get(1).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(2).getToken());
        assertEquals(Token.LEFT_BRACE, tableView.getItems().get(3).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(4).getToken());
        assertEquals(Token.INTEGER, tableView.getItems().get(5).getToken());
        assertEquals(Token.PLUS, tableView.getItems().get(6).getToken());
        assertEquals(Token.SEMICOLON, tableView.getItems().get(7).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(8).getToken());
        assertEquals(Token.KEYWORD, tableView.getItems().get(9).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, tableView.getItems().get(10).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, tableView.getItems().get(11).getToken());
        assertEquals(Token.SEMICOLON, tableView.getItems().get(12).getToken());
        assertEquals(Token.RIGHT_BRACE, tableView.getItems().get(13).getToken());

    }
    
}
