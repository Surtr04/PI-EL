package Robot;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.antlr.runtime.*;

class WRunnable implements Runnable{
	JFrame _j;
	public WRunnable(JFrame j){
		this._j = j;
	}
    public void run() {
        this._j.setVisible(true);
    }
}
public class __Test__ {

	
    public static void main(String args[]) throws Exception {
    	JFrame janela = new JFrame();
    	janela.getContentPane().setLayout(null);
    	janela.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.awt.EventQueue.invokeLater(new WRunnable(janela));
    	JFileChooser chooser = new JFileChooser();
    	AV3Lexer lex;
        int returnVal = chooser.showOpenDialog(janela);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        	lex = new AV3Lexer(new ANTLRFileStream(chooser.getSelectedFile().getAbsolutePath(), "UTF8"));
        else{
        	System.exit(0);
        	 return;
        }
        
        CommonTokenStream tokens = new CommonTokenStream(lex);

       
        AV3Parser g = new AV3Parser(tokens, null);
        try {
            g.robot(janela);
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}