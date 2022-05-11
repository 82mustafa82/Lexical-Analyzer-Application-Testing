package br.ufop.tomaz;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.ufop.tomaz.controller.FXMLMain;
import br.ufop.tomaz.model.Automaton;
import br.ufop.tomaz.model.Lexeme;
import br.ufop.tomaz.model.Lexical_Analyzer;
import br.ufop.tomaz.model.Token;
import javafx.fxml.FXML;

public class TestClass {
    
    private Automaton automaton;
    private Lexical_Analyzer lexical_Analyzer;
    private FXMLMain fxmlMain;


    void setPrimitives(){
        automaton = new Automaton();
        lexical_Analyzer = new Lexical_Analyzer();
        fxmlMain = new FXMLMain();
    }

    @Test
    public void testForAutomaton1(){

        setPrimitives();
        assertEquals(Token.FLOAT, automaton.evaluate("100.888"));

    }

    @Test
    public void testForAutomaton12(){

        setPrimitives();
        assertEquals(Token.FLOAT, automaton.evaluate(" 100.888"));

    }

    @Test
    public void testForAutomaton2(){

        setPrimitives();
        assertEquals(Token.STRING, automaton.evaluate("\"This is String\""));

    }

    @Test
    public void testForAutomaton22(){

        setPrimitives();
        assertEquals(Token.STRING, automaton.evaluate("\"\"This is String\"\""));

    }

    @Test
    public void testForAutomaton3(){

        setPrimitives();
        assertEquals(Token.INTEGER, automaton.evaluate("1001"));

    }

    @Test
    public void testForAutomaton32(){

        setPrimitives();
        assertEquals(Token.INTEGER, automaton.evaluate("1001 "));

    }

    @Test
    public void testForAutomaton4(){

        setPrimitives();
        assertEquals(Token.IDENTIFIER, automaton.evaluate("aVar12389"));

    }

    @Test
    public void testForAutomaton42(){

        setPrimitives();
        assertEquals(Token.IDENTIFIER, automaton.evaluate("struct.substruct"));

    }

    @Test
    public void testForAutomaton5(){

        setPrimitives();
        assertEquals(Token.INVALID, automaton.evaluate("nmn3||+%"));

    }

    @Test
    public void testForAutomaton52(){

        setPrimitives();
        assertEquals(Token.INVALID, automaton.evaluate("aVAr898"));

    }
    
    @Test
    public void testForLexicalAnalyzer1() throws InterruptedException{

        setPrimitives();
        Map<Integer, String> lines = new HashMap<>();
        lines.put(1, "var := 5");
        List<Lexeme> lexemes = lexical_Analyzer.analyzeCode(lines);
        assertEquals(3, lexemes.size());
        assertEquals(Token.ASSIGNMENT_OPERATOR, lexemes.get(0).getToken());
        assertEquals(Token.INTEGER, lexemes.get(1).getToken());
        assertEquals(Token.IDENTIFIER, lexemes.get(2).getToken());

    }
    
    @Test
    public void testForLexicalAnalyzer2() throws InterruptedException{

        setPrimitives();
        Map<Integer, String> lines = new HashMap<>();
        lines.put(1, "var := 3 + val");
        List<Lexeme> lexemes = lexical_Analyzer.analyzeCode(lines);
        assertEquals(5, lexemes.size());
        assertEquals(Token.IDENTIFIER, lexemes.get(0).getToken());
        assertEquals(Token.ASSIGNMENT_OPERATOR, lexemes.get(1).getToken());
        assertEquals(Token.INTEGER, lexemes.get(2).getToken());
        assertEquals(Token.IDENTIFIER, lexemes.get(3).getToken());
        assertEquals(Token.PLUS, lexemes.get(4).getToken());

    }
    
    @Test
    public void testForLexicalAnalyzer3(){

        lexical_Analyzer = new Lexical_Analyzer();
        Map<Integer, String> lines = new HashMap<>();
        lines.put(1, "if ( i <> 2 )");
        lines.put(2, "  print ( \"this not equals two\" )");
        List<Lexeme> lexemes = lexical_Analyzer.analyzeCode(lines);
        assertEquals(10, lexemes.size());
        assertEquals(Token.NOT_EQUALS, lexemes.get(0).getToken());
        assertEquals(Token.INTEGER, lexemes.get(1).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, lexemes.get(2).getToken());
        assertEquals(Token.IDENTIFIER, lexemes.get(3).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, lexemes.get(4).getToken());
        assertEquals(Token.KEYWORD, lexemes.get(5).getToken());
        assertEquals(Token.KEYWORD, lexemes.get(6).getToken());
        assertEquals(Token.STRING, lexemes.get(7).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, lexemes.get(8).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, lexemes.get(9).getToken());

    }
    
    @Test
    public void testForLexicalAnalyzer4() throws InterruptedException{

        lexical_Analyzer = new Lexical_Analyzer();
        Map<Integer, String> lines = new HashMap<>();
        lines.put(1, "for ( i := 1 ; I < 4 ; i + + ) {");
        lines.put(2, "  if ( I / 2 = 1 )");
        lines.put(3, "      print ( \"valuesisodd\" ) }");
        List<Lexeme> lexemes = lexical_Analyzer.analyzeCode(lines);
        assertEquals(25, lexemes.size());
        assertEquals(Token.INTEGER, lexemes.get(0).getToken());
        assertEquals(Token.ASSIGNMENT_OPERATOR, lexemes.get(1).getToken());
        assertEquals(Token.INTEGER, lexemes.get(2).getToken());
        assertEquals(Token.KEYWORD, lexemes.get(3).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, lexemes.get(4).getToken());
        assertEquals(Token.IDENTIFIER, lexemes.get(5).getToken());
        assertEquals(Token.IDENTIFIER, lexemes.get(6).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, lexemes.get(7).getToken());
        assertEquals(Token.SEMICOLON, lexemes.get(8).getToken());
        assertEquals(Token.PLUS, lexemes.get(9).getToken());
        assertEquals(Token.LEFT_BRACE, lexemes.get(10).getToken());
        assertEquals(Token.LOWER_THAN, lexemes.get(11).getToken());
        assertEquals(Token.INTEGER, lexemes.get(12).getToken());
        assertEquals(Token.INTEGER, lexemes.get(13).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, lexemes.get(14).getToken());
        assertEquals(Token.IDENTIFIER, lexemes.get(15).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, lexemes.get(16).getToken());
        assertEquals(Token.KEYWORD, lexemes.get(17).getToken());
        assertEquals(Token.EQUAL, lexemes.get(18).getToken());
        assertEquals(Token.DIVIDE, lexemes.get(19).getToken());
        assertEquals(Token.KEYWORD, lexemes.get(20).getToken());
        assertEquals(Token.LEFT_PARENTHESIS, lexemes.get(21).getToken());
        assertEquals(Token.RIGHT_PARENTHESIS, lexemes.get(22).getToken());
        assertEquals(Token.STRING, lexemes.get(23).getToken());
        assertEquals(Token.RIGHT_BRACE, lexemes.get(24).getToken());

    }
    
    @Test
    public void testForLexicalAnalyzer5(){

        lexical_Analyzer = new Lexical_Analyzer();
        Map<Integer, String> lines = new HashMap<>();
        lines.put(1, "val:=4val ++ 4");
        List<Lexeme> lexemes = lexical_Analyzer.analyzeCode(lines);
        assertEquals(Token.IDENTIFIER, lexemes.get(0).getToken());
        assertEquals(Token.INVALID, lexemes.get(1).getToken());
        assertEquals(Token.ASSIGNMENT_OPERATOR, lexemes.get(2).getToken());
        assertEquals(Token.INVALID, lexemes.get(3).getToken());
        assertEquals(Token.INTEGER, lexemes.get(4).getToken());

    }
    
    @Test
    public void testForLexicalAnalyzer6(){

        lexical_Analyzer = new Lexical_Analyzer();
        Map<Integer, String> lines = new HashMap<>();
        lines.put(1, "for(i;I<4 ;i++){");
        lines.put(2, "print(\"Hello World\")}");
        List<Lexeme> lexemes = lexical_Analyzer.analyzeCode(lines);
        assertEquals(17, lexemes.size());

    }

}
