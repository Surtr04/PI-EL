import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        ficha3Lexer lex = new ficha3Lexer(new ANTLRFileStream("../ficha3.input", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ficha3Parser g = new ficha3Parser(tokens, 49101, null);
        try {
            g.facturas();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
