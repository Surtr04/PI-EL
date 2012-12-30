
package parser;

import imc.*;
import org.antlr.runtime.*;


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
        
        IMC_Error e = g.info.getErrors();        
        for(String s : e.getErrorList()) {
        	System.out.println(s);
        }
                             
        System.out.println("\n\n");
        for(String s : e.getWarningList()) {
        	System.out.println(s);
        }
        
        
    }
}