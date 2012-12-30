import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        IMCLexer lex = new IMCLexer(new ANTLRFileStream("/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV2/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        IMCParser g = new IMCParser(tokens);
        try {
            g.imc();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}