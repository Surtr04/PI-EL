package Robot;

import org.antlr.runtime.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        AV3Lexer lex = new AV3Lexer(new ANTLRFileStream("/Users/rmb/Documents/MEI/EL/PI-EL/EG/AV3/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        AV3Parser g = new AV3Parser(tokens, null);
        try {
            g.robot();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}