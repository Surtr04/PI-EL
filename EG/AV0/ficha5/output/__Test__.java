import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        ficha5Lexer lex = new ficha5Lexer(new ANTLRFileStream("/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV0/ficha5/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ficha5Parser g = new ficha5Parser(tokens, 49101, null);
        try {
            g.biblioteca();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}